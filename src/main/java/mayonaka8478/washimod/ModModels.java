package mayonaka8478.washimod;

import mayonaka8478.washimod.block.BlockModelLogPaperBush;
import mayonaka8478.washimod.block.BlockModelSlabTatami;
import mayonaka8478.washimod.block.BlockModelStairsTatami;
import mayonaka8478.washimod.block.ModBlocks;
import mayonaka8478.washimod.item.ModItems;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.client.render.block.model.generic.BlockModelGenericAxis;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.util.helper.Side;

public class ModModels {
	public static void initBlockModels(BlockModelDispatcher dispatcher) {
		//PlantsBlocks
		//bamboo_shoot
		dispatcher.addDispatch(new BlockModelCrossedSquares<>(ModBlocks.bamboo_shoot).setAllTextures("washimod:block/bamboo_shoot"));
		//bamboo
		dispatcher.addDispatch(new BlockModelGeneric<>(ModBlocks.bamboo, BlockModelDispatcher.loadDataModel("washimod:block/bamboo")).render3D(false));
		//bamboo_cut
		dispatcher.addDispatch(new BlockModelGenericAxis<>(ModBlocks.bamboo_cut, BlockModelDispatcher.loadDataModel("washimod:block/bamboo_cut")).render3D(false));
		//log_paper_bush
		dispatcher.addDispatch(new BlockModelLogPaperBush<>(ModBlocks.log_paper_bush).render3D(false));

		//BuildingBlocks
		//tatami
		dispatcher.addDispatch(new BlockModelAxisAligned<>(ModBlocks.tatami)
			.setAllTextures("washimod:block/tatami").setTex("washimod:block/tatami_top", Side.TOP, Side.BOTTOM));
		//slab_tatami
		dispatcher.addDispatch(new BlockModelSlabTatami<>(ModBlocks.slab_tatami, "washimod:block/slab_tatami"));
		//stairs_tatami
		dispatcher.addDispatch(new BlockModelStairsTatami<>(ModBlocks.stairs_tatami, "washimod:block/stairs_tatami"));
		//tatami_suntan
		dispatcher.addDispatch(new BlockModelAxisAligned<>(ModBlocks.tatami_suntan)
			.setAllTextures("washimod:block/tatami_suntan").setTex("washimod:block/tatami_suntan_top", Side.TOP, Side.BOTTOM));
		//slab_tatami_suntan
		dispatcher.addDispatch(new BlockModelSlabTatami<>(ModBlocks.slab_tatami_suntan, "washimod:block/slab_tatami_suntan"));
		//stairs_tatami_suntan
		dispatcher.addDispatch(new BlockModelStairsTatami<>(ModBlocks.stairs_tatami_suntan, "washimod:block/stairs_tatami_suntan"));
		//bamboo_works
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.bamboo_works).setAllTextures("washimod:block/bamboo_works"));
		//slab_bamboo_works
		dispatcher.addDispatch(new BlockModelSlab<>(ModBlocks.slab_bamboo_works).setAllTextures("washimod:block/bamboo_works"));
		//stairs_bamboo_works
		dispatcher.addDispatch(new BlockModelStairs<>(ModBlocks.stairs_bamboo_works).setAllTextures("washimod:block/bamboo_works"));
	}


	public static void initItemModels(ItemModelDispatcher dispatcher) {
		//bamboo_shoot (overwrite item block model)
		dispatcher.addDispatch(new ItemModelStandard(ModBlocks.bamboo_shoot.asItem()).setIcon("washimod:item/bamboo_shoot"));
		//bamboo
		dispatcher.addDispatch(new ItemModelStandard(ModItems.bamboo));
	}
}
