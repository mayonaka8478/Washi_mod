package mayonaka8478.washimod.block;

import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGenericStairs;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockModelStairsTatami<T extends BlockLogic> extends BlockModelGenericStairs<T> {
	public BlockModelStairsTatami(@NotNull Block<T> block, @NotNull String modelId) {
		super(block, BlockModelDispatcher.loadDataModel(modelId));
	}

	@Override
	public boolean renderAttached(
		@NotNull TessellatorGeneral tessellator,
		@NotNull WorldSource worldSource,
		@NotNull TilePosc tilePos,
		boolean cullFaces,
		@Nullable IconCoordinate overrideTexture
	) {
		int meta = worldSource.getBlockData(tilePos);
		int hRotation = meta & 0b11;
		int vRotation = (meta & 0b1000) >> 3;

		int yRot = switch (hRotation) {
			case 0 -> 0;
			case 1 -> 2;
			case 2 -> 3;
			default -> 1;
		};
		return this.getModel(worldSource, tilePos)
			.renderAttached(this, tessellator, worldSource, tilePos, vRotation * 2, yRot, 0, 0.0, 0.0, 0.0, false, cullFaces, overrideTexture);
	}
}
