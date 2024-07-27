package mayonaka8478.washimod.block;

import mayonaka8478.washimod.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

import java.util.Random;

public class Bamboo extends Block
	implements IBonemealable {
	public Bamboo(String key, int id) {
		super(key, id, Material.vegetable);
		this.setTicking(true);
		float f = 0.375f;
		this.setBlockBounds(0.5f - f, 0.0, 0.5f - f, 0.5f + f, 1.0, 0.5f + f);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (world.isAirBlock(x, y + 1, z) && world.getSavedLightValue(LightLayer.Block, x, y + 1, z) >= 1) {
			int l = 1;
			while (world.getBlockId(x, y - l, z) == this.id) {
				++l;
			}
			if (l < 32) {
				int i1 = world.getBlockMetadata(x, y, z);
				if (i1 == 15) {
					world.setBlockWithNotify(x, y + 1, z, this.id);
					world.setBlockMetadataWithNotify(x, y, z, 0);
				} else {
					world.setBlockMetadataWithNotify(x, y, z, i1 + 1);
				}
			}
		}
	}

	@Override
	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		super.onNeighborBlockChange(world, x, y, z, blockId);
		this.func_268_h(world, x, y, z);
	}

	protected final void func_268_h(World world, int i, int j, int k) {
		if (!this.canBlockStay(world, i, j, k)) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, i, j, k, world.getBlockMetadata(i, j, k), null);
			world.setBlockWithNotify(i, j, k, 0);
		}
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return (world.canBlockSeeTheSky(x, y, z)) && this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y - 1, z));
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return super.canPlaceBlockAt(world, x, y, z) && this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y - 1, z));
	}

	protected boolean canThisPlantGrowOnThisBlockID(int i) {
		if (Block.blocksList[i] == null) {
			return false;
		}
		return Block.blocksList[i].hasTag(BlockTags.GROWS_FLOWERS) || Block.blocksList[i] == this;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(ModBlocks.bamboo_cut)};
			default:
				return new ItemStack[]{new ItemStack(ModItems.bamboo, 4)};
		}
	}

	@Override
	public boolean onBonemealUsed(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, Side side, double d, double e) {
		boolean flag = false;

		int height = 0;
		int lowerHeight = 0;
		while (world.getBlockId(x, y + height, z) == this.id) {
			++height;
		}

		while (world.getBlockId(x, y + lowerHeight, z) == this.id) {
			--lowerHeight;
		}
		if (height < 32) {
			//i=x j=y k=z
			if (world.isAirBlock(x, y + height, z)) {
				world.setBlockWithNotify(x, y + height, z, ModBlocks.bamboo.id);
				flag = true;
			}

			for (int j1 = 0; j1 < 16; ++j1) {
				int x2 = x + world.rand.nextInt(2) - world.rand.nextInt(2);
				int y2 = y + lowerHeight + world.rand.nextInt(2) - world.rand.nextInt(5);
				int z2 = z + world.rand.nextInt(2) - world.rand.nextInt(2);
				if (world.getBlockId(x2, y2, z2) != 0) continue;
				if (world.rand.nextFloat() < 0.5F && ModBlocks.bamboo_shoot.canPlaceBlockAt(world, x2, y2, z2)) {
					flag = true;
					world.setBlockWithNotify(x2, y2, z2, ModBlocks.bamboo_shoot.id);
				}
			}
		}
		//骨粉消費するやつ
		if (entityPlayer.getGamemode().consumeBlocks()) {
			--itemStack.stackSize;
		}
		return flag;
	}
}
