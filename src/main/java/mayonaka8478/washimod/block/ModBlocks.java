package mayonaka8478.washimod.block;

import mayonaka8478.washimod.IDUtils;
import mayonaka8478.washimod.WashiMod;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.block.ItemBlockSlab;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

import java.util.Random;

public class ModBlocks {
	//PlantsBlocks
	public static Block<? extends BlockLogic> bamboo_shoot;
	public static Block<? extends BlockLogic> bamboo;
	public static Block<? extends BlockLogic> bamboo_cut;
	public static Block<? extends BlockLogic> log_paper_bush;
	//BuildingBlocks
	public static Block<? extends BlockLogic> tatami;
	public static Block<? extends BlockLogic> slab_tatami;
	public static Block<? extends BlockLogic> stairs_tatami;
	public static Block<? extends BlockLogic> tatami_suntan;
	public static Block<? extends BlockLogic> slab_tatami_suntan;
	public static Block<? extends BlockLogic> stairs_tatami_suntan;
	public static Block<? extends BlockLogic> bamboo_works;
	public static Block<? extends BlockLogicSlab> slab_bamboo_works;
	public static Block<? extends BlockLogicStairs> stairs_bamboo_works;

	public static void createBlocks() {
		CreativeInventoryPlacement.Category categoryMisc = new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS);

		//PlantsBlocks
		//bamboo_shoot
		bamboo_shoot = new BlockBuilder(WashiMod.MOD_ID)
			.setTicking(true)
			.setResistance(3.0f)
			.setHardness(0.0f)
			.setBlockSound(BlockSounds.STONE)
			.setTags(BlockTags.MINEABLE_BY_HOE)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("bamboo_shoot", "bamboo_shoot", IDUtils.getCurrPlantsBlockId(), b -> new BlockLogicBambooShoot(b));
		//bamboo
		bamboo = new BlockBuilder(WashiMod.MOD_ID)
			.setTicking(true)
			.setResistance(3.0f)
			.setHardness(0.0f)
			.setBlockSound(BlockSounds.STONE)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("bamboo", "bamboo", IDUtils.getCurrPlantsBlockId(), b -> new BlockLogicBamboo(b));
		//bamboo_cut
		bamboo_cut = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(3.0f)
			.setHardness(0.0f)
			.setBlockSound(BlockSounds.STONE)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("bamboo_cut", "bamboo_cut", IDUtils.getCurrPlantsBlockId(), b -> new BlockLogicBambooCut(b));
		//log_paper_bush
		log_paper_bush = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(3.0f)
			.setHardness(2.0f)
			.setBlockSound(BlockSounds.WOOD)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("log.paper_bush", "log_paper_bush", IDUtils.getCurrPlantsBlockId(), b -> new BlockLogicLogPaperBush(b));

		//BuildingBlocks
		//tatami
		tatami = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(5.0f)
			.setHardness(0.1f)
			.setBlockSound(BlockSounds.GRASS)
			.setTicking(true)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("tatami", "tatami", IDUtils.getCurrBuildingBlockId(),
				b -> new BlockLogicAxisAligned(b, Materials.GRASS) {
					public void updateTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand, boolean isRandomTick) {
						if (rand.nextInt(5) == 0) {
							if (world.dimension == Dimension.NETHER) {
								world.setBlockTypeDataNotify(tilePos, ModBlocks.tatami_suntan, world.getBlockData(tilePos));
							}
						}
					}
				});
		//slab_tatami
		slab_tatami = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(5.0f)
			.setHardness(0.1f)
			.setUseInternalLight()
			.setBlockSound(BlockSounds.GRASS)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("slab.tatami", "slab_tatami", IDUtils.getCurrBuildingBlockId(),
				b -> new BlockLogicSlabTatami(b, tatami) {
					public void updateTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand, boolean isRandomTick) {
						if (rand.nextInt(5) == 0) {
							if (world.dimension == Dimension.NETHER) {
								world.setBlockTypeDataNotify(tilePos, ModBlocks.slab_tatami_suntan, world.getBlockData(tilePos));
							}
						}
					}
				});
		//stairs_tatami
		stairs_tatami = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(5.0f)
			.setHardness(0.1f)
			.setUseInternalLight()
			.setBlockSound(BlockSounds.GRASS)
			.setTicking(true)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("stairs.tatami", "stairs_tatami", IDUtils.getCurrBuildingBlockId(),
				b -> new BlockLogicStairs(b, tatami) {
					public void updateTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand, boolean isRandomTick) {
						if (rand.nextInt(5) == 0) {
							if (world.dimension == Dimension.NETHER) {
								world.setBlockTypeDataNotify(tilePos, ModBlocks.stairs_tatami_suntan, world.getBlockData(tilePos));
							}
						}
					}
				});
		//tatami_suntan
		tatami_suntan = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(5.0f)
			.setHardness(0.1f)
			.setBlockSound(BlockSounds.GRASS)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("tatami_suntan", "tatami_suntan", IDUtils.getCurrBuildingBlockId(), b -> new BlockLogicAxisAligned(b, Materials.GRASS));
		//slab_tatami_suntan
		slab_tatami_suntan = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(5.0f)
			.setHardness(0.1f)
			.setUseInternalLight()
			.setBlockSound(BlockSounds.GRASS)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("slab.tatami_suntan", "slab_tatami_suntan", IDUtils.getCurrBuildingBlockId(), b -> new BlockLogicSlabTatami(b, tatami_suntan));
		//stairs_tatami_suntan
		stairs_tatami_suntan = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(5.0f)
			.setHardness(0.1f)
			.setUseInternalLight()
			.setBlockSound(BlockSounds.GRASS)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("stairs.tatami_suntan", "stairs_tatami_suntan", IDUtils.getCurrBuildingBlockId(), b -> new BlockLogicStairs(b, tatami_suntan));
		//bamboo_works
		bamboo_works = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(3.0f)
			.setHardness(2.0f)
			.setBlockSound(BlockSounds.WOOD)
			.setFlammability(5, 20)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("bamboo_works", "bamboo_works", IDUtils.getCurrBuildingBlockId(), b -> new BlockLogic(b, Materials.WOOD));
		//slab_bamboo_works
		slab_bamboo_works = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(3.0f)
			.setHardness(2.0f)
			.setUseInternalLight()
			.setBlockSound(BlockSounds.WOOD)
			.setFlammability(5, 20)
			.setTags(BlockTags.MINEABLE_BY_AXE)
			.setBlockItem(ItemBlockSlab::new)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("slab.bamboo_works", "slab_bamboo_works", IDUtils.getCurrBuildingBlockId(), b -> new BlockLogicSlab(b, bamboo_works));
		//stairs_bamboo_works
		stairs_bamboo_works = new BlockBuilder(WashiMod.MOD_ID)
			.setResistance(3.0f)
			.setHardness(2.0f)
			.setUseInternalLight()
			.setBlockSound(BlockSounds.WOOD)
			.setFlammability(5, 20)
			.setTags(BlockTags.MINEABLE_BY_AXE)
			.setCreativeInventoryPlacement(categoryMisc)
			.build("stairs.bamboo_works", "stairs_bamboo_works", IDUtils.getCurrBuildingBlockId(), b -> new BlockLogicStairs(b, bamboo_works));
	}
}
