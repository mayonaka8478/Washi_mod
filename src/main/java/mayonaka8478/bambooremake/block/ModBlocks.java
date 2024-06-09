package mayonaka8478.bambooremake.block;

import mayonaka8478.bambooremake.BambooRemake;
import mayonaka8478.bambooremake.IDUtils;
import net.minecraft.client.render.block.model.BlockModelAxisAligned;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockAxisAligned;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import org.useless.dragonfly.model.block.DFBlockModelBuilder;
import turniplabs.halplibe.helper.BlockBuilder;

public class ModBlocks {
	//tatami
	public static final Block tatami = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setBlockSound(BlockSounds.GRASS)
		.setBlockModel(block -> {
			return new BlockModelAxisAligned<>(block).withTextures("bambooremake:block/tatami_top", "bambooremake:block/tatami");
		})
		.build(new BlockAxisAligned("tatami", IDUtils.getCurrBlockId(), Material.decoration));
	//bamboo_works
	public static final Block bamboo_works = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(3.0f)
		.setHardness(2.0f)
		.setBlockSound(BlockSounds.WOOD)
		.setFlammability(5, 20)
		.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
		.setTextures("bambooremake:block/bamboo_works")
		.build(new BlockAxisAligned("bamboo_works", IDUtils.getCurrBlockId(), Material.decoration));
	//bamboo_shoot
	public static final Block bamboo_shoot = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(3.0f)
		.setHardness(0.0f)
		.setBlockSound(BlockSounds.STONE)
		.setBlockModel(block -> new BlockModelCrossedSquares<>(block).withTextures("bambooremake:block/bamboo_shoot"))
		.setTags(BlockTags.MINEABLE_BY_HOE)
		.setItemModel(item -> {
			return new ItemModelStandard(item, BambooRemake.MOD_ID);
		})
		.build(new BambooShoot("bamboo_shoot", IDUtils.getCurrBlockId()));
	//bamboo
	public static final Block bamboo = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(3.0f)
		.setHardness(0.0f)
		.setBlockSound(BlockSounds.STONE)
		.setBlockModel(block -> new BlockModelBamboo<>(block).withTextures("bambooremake:block/bamboo"))
		.build(new Bamboo("bamboo", IDUtils.getCurrBlockId()));
	//bamboo_cut
	public static final Block bamboo_cut = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(3.0f)
		.setHardness(0.0f)
		.setBlockSound(BlockSounds.STONE)
		.setIcon("bambooremake:block/bamboo")
		.setBlockModel(block -> new DFBlockModelBuilder(BambooRemake.MOD_ID)
			.setBlockModel("block/bamboo_cut.json")
			.setBlockState("bamboo_cut.json")
			.setMetaStateInterpreter(new BambooCutMetaStateInterpreter())
			.setRender3D(false)
			.build(block))
		.build(new BambooCut("bamboo_cut", IDUtils.getCurrBlockId()));

	public static void createBlocks() {
	}
}
