package mayonaka8478.bambooremake.block;

import mayonaka8478.bambooremake.BambooRemake;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockAxisAligned;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

public class ModBlocks {
	public static final Block tatami = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.5f)
		.setBlockSound(BlockSounds.GRASS)
		.build(new BlockAxisAligned("tatami", 8401, Material.decoration));

	public static void createBlocks() {

	}
}
