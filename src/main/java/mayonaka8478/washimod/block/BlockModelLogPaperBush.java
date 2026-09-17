package mayonaka8478.washimod.block;

import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicAxisAligned;
import net.minecraft.core.util.helper.Axis;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.useless.dragonfly.models.block.StaticBlockModel;

public class BlockModelLogPaperBush<T extends BlockLogic> extends BlockModelGeneric<T> {
	@NotNull
	public final StaticBlockModel altModel;
	@NotNull
	public final StaticBlockModel altAllModel;

	public BlockModelLogPaperBush(@NotNull Block<T> block) {
		super(block, BlockModelDispatcher.loadDataModel("washimod:block/log_paper_bush"));
		this.altModel = BlockModelDispatcher.loadDataModel("washimod:block/log_paper_bush_alt").asModel();
		this.altAllModel = BlockModelDispatcher.loadDataModel("washimod:block/log_paper_bush_alt_all").asModel();
	}

	@Override
	public @NotNull StaticBlockModel getModelFromData(int data) {
		Alt alt = getAltFromData(data);
		//Model switching from resources/assets/washimod/blockstates/log_paper_bush.json in 7.2
		return switch (alt) {
			case X, Z, S -> this.altModel;
			case A -> this.altAllModel;
			default -> this.staticModel;
		};
	}

	@Override
	public boolean renderAttached(
		@NotNull TessellatorGeneral tessellator,
		@NotNull WorldSource worldSource,
		@NotNull TilePosc tilePos,
		boolean cullFaces,
		@Nullable IconCoordinate overrideTexture
	) {
		int data = worldSource.getBlockData(tilePos);
		Axis axis = BlockLogicAxisAligned.metaToAxis(data);
		Alt alt = getAltFromData(data);
		//Model rotation from resources/assets/washimod/blockstates/log_paper_bush.json in 7.2
		return switch (axis) {
			case X -> this.getModel(worldSource, tilePos)
				.renderAttached(this, tessellator, worldSource, tilePos, 1, 0, 0, 0.0, 0.0, 0.0, false, cullFaces, overrideTexture);
			case Y -> switch (alt) {
				case Z -> this.getModel(worldSource, tilePos)
					.renderAttached(this, tessellator, worldSource, tilePos, 0, 1, 0, 0.0, 0.0, 0.0, false, cullFaces, overrideTexture);
				case S -> this.getModel(worldSource, tilePos)
					.renderAttached(this, tessellator, worldSource, tilePos, 1, 0, 0, 0.0, 0.0, 0.0, false, cullFaces, overrideTexture);
				default -> this.getModel(worldSource, tilePos)
					.renderAttached(this, tessellator, worldSource, tilePos, 0, 0, 0, 0.0, 0.0, 0.0, false, cullFaces, overrideTexture);
			};
			case Z -> this.getModel(worldSource, tilePos)
				.renderAttached(this, tessellator, worldSource, tilePos, 0, 0, 1, 0.0, 0.0, 0.0, false, cullFaces, overrideTexture);
			default -> false;
		};
	}

	public Alt getAltFromData(int data) {
		//'Alt' value selection from mayonaka8478.washimod.block.LogPaperBushMetaStateInterpreter in 7.2
		int alt = data & 4;
		return switch (alt) {
			case 1 -> Alt.Z;
			case 2 -> Alt.S;
			case 3 -> Alt.A;
			default -> Alt.X;
		};
	}

	public enum Alt {
		X, Z, S, A
	}
}
