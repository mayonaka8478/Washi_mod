package mayonaka8478.bambooremake.block;

import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;

public class BlockModelBamboo extends BlockModel {
	public BlockModelBamboo(Block block) {
	}

	@Override
	public boolean render(Tessellator tessellator, int i, int j, int k) {
		return false;
	}

	@Override
	public void renderBlockOnInventory(Tessellator tessellator, int i, float f, float g) {

	}

	@Override
	public boolean shouldItemRender3d() {
		return false;
	}

	@Override
	public float getItemRenderScale() {
		return 0;
	}

	@Override
	public IconCoordinate getBlockTexture(WorldSource worldSource, int i, int j, int k, Side side) {
		return null;
	}

	@Override
	public IconCoordinate getBlockOverbrightTexture(WorldSource worldSource, int i, int j, int k, int l) {
		return null;
	}

	@Override
	public IconCoordinate getBlockOverbrightTextureFromSideAndMeta(Side side, int i) {
		return null;
	}

	@Override
	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int i) {
		return null;
	}

	@Override
	public IconCoordinate getParticleTexture(Side side, int i) {
		return null;
	}

	@Override
	public boolean shouldSideBeRendered(WorldSource worldSource, int i, int j, int k, int l, int m) {
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(WorldSource worldSource, int i, int j, int k, int l) {
		return false;
	}

	@Override
	public boolean shouldSideBeColored(WorldSource worldSource, int i, int j, int k, int l, int m) {
		return false;
	}
}
