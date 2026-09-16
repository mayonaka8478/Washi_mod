package mayonaka8478.washimod.block;

import mayonaka8478.washimod.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBdc;

import java.util.Random;

public class BlockLogicBamboo extends BlockLogic implements IBonemealable {
	public BlockLogicBamboo(@NotNull Block<?> block) {
		super(block, Materials.VEGETABLE);
		float f = 0.375f;
		this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
	}

	@Override
	public void updateTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand, boolean isRandomTick) {
		TilePos abovePos = tilePos.add(Direction.UP, new TilePos());
		if (world.isAirBlock(abovePos) && world.getSavedLightValue(LightLayer.Block, abovePos) >= 1) {
			int l = 1;
			while (world.getBlockType(tilePos.sub(0, l, 0, new TilePos())) == this.block) {
				++l;
			}
			if (l < 32) {
				int data = world.getBlockData(tilePos);
				if (data == 15) {
					world.setBlockTypeNotify(abovePos, this.block);
					world.setBlockDataNotify(tilePos, 0);
				} else {
					world.setBlockDataNotify(tilePos, data + 1);
				}
			}
		}
	}

	@Override
	public AABBdc getCollisionAABB(@NotNull WorldSource world, @NotNull TilePosc tilePos) {
		return null;
	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean isCubeShaped() {
		return false;
	}

	@Override
	public void onNeighborChanged(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Block<?> block) {
		super.onNeighborChanged(world, tilePos, block);
		if (!this.canStay(world, tilePos)) {
			this.dropWithCause(world, EnumDropCause.WORLD, tilePos, world.getBlockData(tilePos), null, null);
			world.setBlockTypeNotify(tilePos, Blocks.AIR);
		}
	}

	@Override
	public boolean canPlaceAt(@NotNull World world, @NotNull TilePosc tilePos) {
		return super.canPlaceAt(world, tilePos) && this.canGrowOn(world.getBlockType(tilePos.add(Direction.DOWN, new TilePos())));
	}

	@Override
	public boolean canStay(@NotNull World world, @NotNull TilePosc tilePos) {
		return world.canBlockSeeSky(tilePos) && this.canGrowOn(world.getBlockType(tilePos.add(Direction.DOWN, new TilePos())));
	}

	protected boolean canGrowOn(@NotNull Block<?> block) {
		return block.hasTag(BlockTags.GROWS_FLOWERS) || block == this.block;
	}

	@Override
	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, @NotNull TilePosc tilePos, int meta, TileEntity tileEntity) {
		return switch (dropCause) {
			case SILK_TOUCH, PICK_BLOCK ->
				new ItemStack[]{new ItemStack(ModBlocks.bamboo_cut)};
			default ->
				new ItemStack[]{new ItemStack(ModItems.bamboo, 4)};
		};
	}

	@Override
	public boolean onBonemealUsed(@NotNull ItemStack itemStack, Player player, @NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side, double xHit, double yHit) {
		int x = tilePos.x();
		int y = tilePos.y();
		int z = tilePos.z();

		boolean flag = false;

		int height = 0;
		int lowerHeight = 0;

		while (world.getBlockType(new TilePos(x, y + height, z)) == this.block) {
			++height;
		}

		while (world.getBlockType(new TilePos(x, y + lowerHeight, z)) == this.block) {
			--lowerHeight;
		}

		if (height < 32) {
			//i=x j=y k=z
			TilePos newBambooPos = new TilePos(x, y + height, z);
			if (world.isAirBlock(newBambooPos)) {
				world.setBlockTypeNotify(newBambooPos, ModBlocks.bamboo);
				flag = true;
			}

			for (int j1 = 0; j1 < 16; ++j1) {
				int x2 = x + world.rand.nextInt(2) - world.rand.nextInt(2);
				int y2 = y + lowerHeight + world.rand.nextInt(2) - world.rand.nextInt(5);
				int z2 = z + world.rand.nextInt(2) - world.rand.nextInt(2);
				TilePos newBambooShootPos = new TilePos(x2, y2, z2);
				if (!world.isAirBlock(newBambooShootPos)) continue;
				if (world.rand.nextFloat() < 0.5F && ModBlocks.bamboo_shoot.canPlaceAt(world, newBambooShootPos)) {
					flag = true;
					world.setBlockTypeNotify(newBambooShootPos, ModBlocks.bamboo_shoot);
				}
			}
		}
		//骨粉消費するやつ
		if (player != null && player.getGamemode().hasBlockConsumption()) {
			--itemStack.stackSize;
		}
		return flag;
	}
}
