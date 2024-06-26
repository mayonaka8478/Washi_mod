package mayonaka8478.bambooremake;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.MethodParametersAnnotation;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureBambooShoots
	extends WorldFeature {
	private final int plantBlockId;

	@MethodParametersAnnotation(names = {"plantBlockId"})
	public WorldFeatureBambooShoots(int plantBlockId) {
		this.plantBlockId = plantBlockId;
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		for (int l = 0; l < 8; ++l) {
			int k1;
			int j1;
			int i1 = x + random.nextInt(2) - random.nextInt(2);
			if (!world.isAirBlock(i1, j1 = y + random.nextInt(1) - random.nextInt(1), k1 = z + random.nextInt(2) - random.nextInt(2)) || !Block.blocksList[this.plantBlockId].canBlockStay(world, i1, j1, k1))
				continue;
			world.setBlock(i1, j1, k1, this.plantBlockId);
		}
		return true;
	}
}
