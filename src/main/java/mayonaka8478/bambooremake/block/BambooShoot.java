package mayonaka8478.bambooremake.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class BambooShoot extends Block {
	public BambooShoot(String key, int id) {
		super(key, id, Material.vegetable);
	}

	@Override
	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return super.canPlaceBlockAt(world, x, y, z) && this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y - 1, z));
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) && this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y - 1, z));
	}

	protected boolean canThisPlantGrowOnThisBlockID(int i) {
		if (Block.blocksList[i] == null) {
			return false;
		}
		return Block.blocksList[i].hasTag(BlockTags.GROWS_FLOWERS);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			default:
				return null;
		}
	}
}
