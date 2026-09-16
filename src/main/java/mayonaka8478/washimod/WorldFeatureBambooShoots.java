package mayonaka8478.washimod;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.MethodParametersAnnotation;
import net.minecraft.core.world.generate.feature.WorldFeatureInterface;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class WorldFeatureBambooShoots implements WorldFeatureInterface {
	private final int plantBlockId;

	@MethodParametersAnnotation(names = {"plantBlockId"})
	public WorldFeatureBambooShoots(int plantBlockId) {
		this.plantBlockId = plantBlockId;
	}

	@Override
	public boolean place(@NotNull World world, @NotNull Random random, @NotNull TilePosc tilePos) {
		//WashiMod.LOGGER.info("Bamboo shoots will be generated around {} in {}.", tilePos, world.dimension);

		for (int l = 0; l < 8; ++l) {
			TilePos placementPos = tilePos.add(random.nextInt(2) - random.nextInt(2), 0, random.nextInt(2) - random.nextInt(2), new TilePos());
			if (!world.isAirBlock(placementPos) || !Blocks.getBlock(plantBlockId).canStay(world, placementPos)) {
				continue;
			}
			world.setBlockType(placementPos, Blocks.getBlock(plantBlockId));
		}
		return true;
	}
}
