package mayonaka8478.bambooremake.block;

import mayonaka8478.bambooremake.BambooRemake;
import mayonaka8478.bambooremake.IDUtils;
import net.minecraft.client.render.block.model.BlockModelAxisAligned;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockAxisAligned;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

public class ModBlocks {
	public static final Block tatami = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setBlockSound(BlockSounds.GRASS)
		.setBlockModel(block -> {
			return new BlockModelAxisAligned<>(block).withTextures("bambooremake:block/tatami_top", "bambooremake:block/tatami");
		})
		.build(new BlockAxisAligned("tatami", IDUtils.getCurrBlockId(), Material.decoration));

	public static void createBlocks() {

	}
}
