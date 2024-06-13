package mayonaka8478.bambooremake.block;

import net.minecraft.core.block.BlockSlab;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class SlabTatami extends BlockSlab {
	public SlabTatami(String key, int id) {
		super(key, id, Material.grass);
	}

	@Override
	public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight)
}
