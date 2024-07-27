package mayonaka8478.washimod;

import mayonaka8478.washimod.block.ModBlocks;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import useless.terrainapi.api.TerrainAPI;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;

public class TerrainAPIPlugin implements TerrainAPI {
	@Override
	public String getModID() {
		return WashiMod.MOD_ID;
	}

	@Override
	public void onInitialize() {
		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureBambooShoots(ModBlocks.bamboo_shoot.id), 6, -1, 1,
			new Biome[]{Biomes.OVERWORLD_RETRO, Biomes.OVERWORLD_FOREST, Biomes.OVERWORLD_RAINFOREST, Biomes.OVERWORLD_BIRCH_FOREST, Biomes.OVERWORLD_SEASONAL_FOREST, Biomes.OVERWORLD_SHRUBLAND, Biomes.OVERWORLD_BOREAL_FOREST, Biomes.OVERWORLD_TAIGA});
	}
}
