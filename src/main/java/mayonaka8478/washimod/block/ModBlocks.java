package mayonaka8478.washimod.block;

import mayonaka8478.washimod.IDUtils;
import mayonaka8478.washimod.WashiMod;
import mayonaka8478.washimod.item.ItemBlockSlabTatami;
import net.minecraft.client.render.block.model.BlockModelAxisAligned;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.block.model.BlockModelSlab;
import net.minecraft.client.render.block.model.BlockModelStairs;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockAxisAligned;
import net.minecraft.core.block.BlockSlab;
import net.minecraft.core.block.BlockStairs;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.block.ItemBlockSlab;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.World;
import org.useless.dragonfly.model.block.DFBlockModelBuilder;
import turniplabs.halplibe.helper.BlockBuilder;

import java.util.Random;

public class ModBlocks {
	//PlantsBlocks
	//bamboo_shoot
	public static final Block bamboo_shoot = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(3.0f)
		.setHardness(0.0f)
		.setBlockSound(BlockSounds.STONE)
		.setBlockModel(block -> new BlockModelCrossedSquares<>(block).withTextures("washimod:block/bamboo_shoot"))
		.setTags(BlockTags.MINEABLE_BY_HOE)
		.setIcon("washimod:item/bamboo_shoot")
		.build(new BambooShoot("bamboo_shoot", IDUtils.getCurrPlantsBlockId()));
	//bamboo
	public static final Block bamboo = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(3.0f)
		.setHardness(0.0f)
		.setBlockSound(BlockSounds.STONE)
		.setBlockModel(block -> new BlockModelBamboo<>(block).withTextures("washimod:block/bamboo"))
		.build(new Bamboo("bamboo", IDUtils.getCurrPlantsBlockId()));
	//bamboo_cut
	public static final Block bamboo_cut = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(3.0f)
		.setHardness(0.0f)
		.setBlockSound(BlockSounds.STONE)
		.setIcon("washimod:block/bamboo")
		.setBlockModel(block -> new DFBlockModelBuilder(WashiMod.MOD_ID)
			.setBlockModel("block/bamboo_cut.json")
			.setBlockState("bamboo_cut.json")
			.setMetaStateInterpreter(new BambooCutMetaStateInterpreter())
			.setRender3D(false)
			.build(block))
		.build(new BambooCut("bamboo_cut", IDUtils.getCurrPlantsBlockId()));
	//log_paper_bush
	public static final Block log_paper_bush = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(3.0f)
		.setHardness(2.0f)
		.setBlockSound(BlockSounds.WOOD)
		.setIcon("washimod:block/log_paper_bush")
		.setBlockModel(block -> new DFBlockModelBuilder(WashiMod.MOD_ID)
			.setBlockModel("block/log_paper_bush.json")
			.setBlockState("log_paper_bush.json")
			.setMetaStateInterpreter(new LogPaperBushMetaStateInterpreter())
			.setRender3D(false)
			.build(block))
		.build(new LogPaperBush("log.paper_bush", IDUtils.getCurrPlantsBlockId()));

	//BuildingBlocks
	//tatami
	public static final Block tatami = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setBlockSound(BlockSounds.GRASS)
		.setBlockModel(block -> {
			return new BlockModelAxisAligned<>(block).withTextures("washimod:block/tatami_top", "washimod:block/tatami");
		})
		.setTicking(true)
		.build(new BlockAxisAligned("tatami", IDUtils.getCurrBuildingBlockId(), Material.grass) {
			public void updateTick(World world, int x, int y, int z, Random rand) {
				if (rand.nextInt(5) == 0) {
					if (world.dimension == Dimension.nether) {
						world.setBlockAndMetadataWithNotify(x, y, z, ModBlocks.tatami_suntan.id, world.getBlockMetadata(x, y, z));
					}
				}
			}
		});
	//slab_tatami
	public static final Block slab_tatami = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setBlockSound(BlockSounds.GRASS)
		.setItemBlock(ItemBlockSlabTatami::new)
		.setBlockModel(block -> new DFBlockModelBuilder(WashiMod.MOD_ID)
			.setBlockModel("block/slab_tatami.json")
			.setBlockState("slab_tatami.json")
			.setMetaStateInterpreter(new SlabTatamiMetaStateInterpreter())
			.setRender3D(true)
			.build(block))
		.setTicking(true)
		.build(new SlabTatami(tatami, IDUtils.getCurrBuildingBlockId()) {
			public void updateTick(World world, int x, int y, int z, Random rand) {
				if (rand.nextInt(5) == 0) {
					if (world.dimension == Dimension.nether) {
						world.setBlockAndMetadataWithNotify(x, y, z, ModBlocks.slab_tatami_suntan.id, world.getBlockMetadata(x, y, z));
					}
				}
			}
		});
	//stairs_tatami
	public static final Block stairs_tatami = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setBlockSound(BlockSounds.GRASS)
		.setBlockModel(block -> new DFBlockModelBuilder(WashiMod.MOD_ID)
			.setBlockModel("block/stairs_tatami.json")
			.setBlockState("stairs_tatami.json")
			.setMetaStateInterpreter(new StairsTatamiMetaStateInterpreter())
			.setRender3D(true)
			.build(block))
		.setTicking(true)
		.build(new BlockStairs(tatami, IDUtils.getCurrBuildingBlockId()) {
			public void updateTick(World world, int x, int y, int z, Random rand) {
				if (rand.nextInt(5) == 0) {
					if (world.dimension == Dimension.nether) {
						world.setBlockAndMetadataWithNotify(x, y, z, ModBlocks.stairs_tatami_suntan.id, world.getBlockMetadata(x, y, z));
					}
				}
			}
		});
	//tatami_suntan
	public static final Block tatami_suntan = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setBlockSound(BlockSounds.GRASS)
		.setBlockModel(block -> {
			return new BlockModelAxisAligned<>(block).withTextures("washimod:block/tatami_suntan_top", "washimod:block/tatami_suntan");
		})
		.build(new BlockAxisAligned("tatami_suntan", IDUtils.getCurrBuildingBlockId(), Material.grass));
	//slab_tatami_suntan
	public static final Block slab_tatami_suntan = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setBlockSound(BlockSounds.GRASS)
		.setItemBlock(ItemBlockSlabTatami::new)
		.setBlockModel(block -> new DFBlockModelBuilder(WashiMod.MOD_ID)
			.setBlockModel("block/slab_tatami_suntan.json")
			.setBlockState("slab_tatami_suntan.json")
			.setMetaStateInterpreter(new SlabTatamiMetaStateInterpreter())
			.setRender3D(true)
			.build(block))
		.build(new SlabTatami(tatami_suntan, IDUtils.getCurrBuildingBlockId()));
	//stairs_tatami_suntan
	public static final Block stairs_tatami_suntan = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setBlockSound(BlockSounds.GRASS)
		.setBlockModel(block -> new DFBlockModelBuilder(WashiMod.MOD_ID)
			.setBlockModel("block/stairs_tatami_suntan.json")
			.setBlockState("stairs_tatami_suntan.json")
			.setMetaStateInterpreter(new StairsTatamiMetaStateInterpreter())
			.setRender3D(true)
			.build(block))
		.build(new BlockStairs(tatami_suntan, IDUtils.getCurrBuildingBlockId()));
	//bamboo_works
	public static final Block bamboo_works = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(3.0f)
		.setHardness(2.0f)
		.setBlockSound(BlockSounds.WOOD)
		.setFlammability(5, 20)
		.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
		.setTextures("washimod:block/bamboo_works")
		.build(new Block("bamboo_works", IDUtils.getCurrBuildingBlockId(), Material.wood));
	//slab_bamboo_works
	public static final Block slab_bamboo_works = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(3.0f)
		.setHardness(2.0f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setItemBlock(ItemBlockSlab::new)
		.setBlockModel(BlockModelSlab::new)
		.setBlockSound(BlockSounds.WOOD)
		.setFlammability(5, 20)
		.setTags(BlockTags.MINEABLE_BY_AXE)
		.setTextures("washimod:block/bamboo_works")
		.build(new BlockSlab(bamboo_works, IDUtils.getCurrBuildingBlockId()));
	//stairs_bamboo_works
	public static final Block stairs_bamboo_works = new BlockBuilder(WashiMod.MOD_ID)
		.setResistance(3.0f)
		.setHardness(2.0f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setBlockModel(BlockModelStairs::new)
		.setBlockSound(BlockSounds.WOOD)
		.setFlammability(5, 20)
		.setTags(BlockTags.MINEABLE_BY_AXE)
		.setTextures("washimod:block/bamboo_works")
		.build(new BlockStairs(bamboo_works, IDUtils.getCurrBuildingBlockId()));
	public static void createBlocks() {
	}
}
