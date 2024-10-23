package mayonaka8478.washimod.block;

import net.minecraft.core.block.BlockAxisAligned;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class LogPaperBush extends BlockAxisAligned {
	public LogPaperBush(String key, int id) {
		super(key, id, Material.wood);
	}

	public void setBlockBoundsBasedOnState(World world, int x, int y, int z) {
		this.setBlockBounds(world.getBlockMetadata(x, y, z));
	}

	public AABB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		this.setBlockBounds(world.getBlockMetadata(x, y, z));
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	public AABB getSelectedBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		this.setBlockBounds(world.getBlockMetadata(x, y, z));
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}

	public void setBlockBounds(int meta) {
		Side side = this.getSideFromMeta(meta);
		float f = 0.375f;
		if (side == Side.TOP) {
			this.setBlockBounds(0.5f - f, 0.0F, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
		} else if (side == Side.NORTH) {
			this.setBlockBounds(0.5f - f, 0.5f - f, 0.0f, 0.5f + f, 0.5f + f, 1.0f);
		} else if (side == Side.EAST) {
			this.setBlockBounds(0.0f, 0.5f - f, 0.5f - f, 1.0f, 0.5f + f, 0.5f + f);
		} else if (side == Side.ALTNORTH) {
			this.setBlockBounds(1.0f, 1.0f - f, 1.0f - f, 1.0f, 1.0f + f, 1.0f + f);
		} else if (side == Side.ALTEAST) {
			this.setBlockBounds(1.0f, 1.0f - f, 1.0f - f, 1.0f, 1.0f + f, 1.0f + f);
		} else if (side == Side.ALTALL) {
			this.setBlockBounds(1.0f, 1.0f - f, 1.0f - f, 1.0f, 1.0f + f, 1.0f + f);
		} else {
			this.setBlockBounds(0.5f - f, 0.0F, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
		}
	}

	public Side getSideFromMeta(int meta) {
		if (meta == 0) {
			return Side.TOP;
		} else if (meta == 1) {
			return Side.NORTH;
		} else if (meta == 2) {
			return Side.EAST;
		} else if (meta == 3) {
			return Side.ALTNORTH;
		} else if (meta == 4) {
			return Side.ALTEAST;
		} else if (meta == 5) {
			return Side.ALTALL;
		} else
			return Side.NONE;
	}
}

@Override
public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
	return null;
}

	//ブロック隣接時に透けて見えるのを阻止するやつ
	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

@Override
public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
	switch (dropCause) {
		default:
			return new ItemStack[]{new ItemStack(this)};
	}
}
