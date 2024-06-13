package mayonaka8478.bambooremake.block;

import net.minecraft.core.block.BlockSlab;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.enums.PlacementMode;
import net.minecraft.core.util.helper.Axis;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class SlabTatami extends BlockSlab {
	public SlabTatami(String key, int id) {
		super(key, id, Material.grass);
	}

	@Override
	public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
		Axis axis = entity.getPlacementDirection(side, PlacementMode.SIDE).getAxis();
		Direction dir = entity.getVerticalPlacementDirection(side, sideHeight);
		int meta = world.getBlockMetadata(x, y, z) & 0xF0;
		if (dir == Direction.DOWN) {
			meta |= 0;
		}
		if (dir == Direction.UP) {
			meta |= 2;
		}
		if (axis == Axis.X) {
			meta |= 0;
		}
		if (axis == Axis.Z) {
			meta |= 3;
		}
		world.setBlockMetadataWithNotify(x, y, z, meta);
}
