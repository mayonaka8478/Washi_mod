package mayonaka8478.washimod.block;

import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGenericSlab;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockModelSlabTatami<T extends BlockLogic> extends BlockModelGenericSlab<T> {
	public BlockModelSlabTatami(@NotNull Block<T> block, @NotNull String baseId) {
		super(block,
			BlockModelDispatcher.loadDataModel(baseId),
			BlockModelDispatcher.loadDataModel(baseId + "_top"),
			BlockModelDispatcher.loadDataModel(baseId + "_double"));
	}

	@Override
	public boolean renderAttached(@NotNull TessellatorGeneral tessellator, @NotNull WorldSource worldSource, @NotNull TilePosc tilePos, boolean cullFaces, @Nullable IconCoordinate overrideTexture) {
		if ((worldSource.getBlockData(tilePos) & 0b100) == 0) {
			//Axis == X
			return this.getModel(worldSource, tilePos)
				.renderAttached(this, tessellator, worldSource, tilePos, 0, 1, 0, 0.0, 0.0, 0.0, false, cullFaces, overrideTexture);
		}

		return this.getModel(worldSource, tilePos)
			.renderAttached(this, tessellator, worldSource, tilePos, 0, 0, 0, 0.0, 0.0, 0.0, false, cullFaces, overrideTexture);
	}
}
