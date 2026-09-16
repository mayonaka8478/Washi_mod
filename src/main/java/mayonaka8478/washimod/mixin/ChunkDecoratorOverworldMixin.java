package mayonaka8478.washimod.mixin;

import mayonaka8478.washimod.WorldFeatureBambooShoots;
import mayonaka8478.washimod.block.ModBlocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.pos.TilePos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = ChunkDecoratorOverworld.class, remap = false)
public abstract class ChunkDecoratorOverworldMixin {
	@Shadow
	@Final
	private World world;

	@Inject(method = "decorate", at = @At(value = "TAIL"))
	public void decorate(Chunk chunk, CallbackInfo ci) {
		int chunkX = chunk.pos.x;
		int chunkZ = chunk.pos.z;

		int x = chunkX * 16;
		int z = chunkZ * 16;
		int y = this.world.getHeightValue(x + 16, z + 16);
		Biome biome = this.world.getBlockBiome(new TilePos(x + 16, y, z + 16));

		Random rand = new Random(this.world.getRandomSeed());
		long l1 = rand.nextLong() / 2L * 2L + 1L;
		long l2 = rand.nextLong() / 2L * 2L + 1L;
		rand.setSeed(chunkX * l1 + chunkZ * l2 ^ this.world.getRandomSeed());

		if (biome == Biomes.OVERWORLD_FOREST ||
			biome == Biomes.OVERWORLD_RAINFOREST ||
			biome == Biomes.OVERWORLD_BIRCH_FOREST ||
			biome == Biomes.OVERWORLD_SEASONAL_FOREST ||
			biome == Biomes.OVERWORLD_SHRUBLAND ||
			biome == Biomes.OVERWORLD_BOREAL_FOREST ||
			biome == Biomes.OVERWORLD_TAIGA) {
			if (rand.nextInt(6) == 0) {
				int i = x + rand.nextInt(16);
				int k = z + rand.nextInt(16);
				int j = world.getHeightValue(i, k);
				TilePos tilePos = new TilePos(i, j, k);
				new WorldFeatureBambooShoots(ModBlocks.bamboo_shoot.id()).place(world, rand, tilePos);
			}
		}
	}
}
