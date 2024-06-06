package mayonaka8478.bambooremake.block;

import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.block.model.BlockModelCropsWheat;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.Side;

public class BlockModelBamboo<T extends Block>
	extends BlockModelStandard<T> {

	public BlockModelBamboo(Block block) {
		super(block);
	}

	@Override
	public boolean render(Tessellator tessellator, int x, int y, int z) {
		this.block.setBlockBoundsBasedOnState(BlockModelCropsWheat.renderBlocks.blockAccess, x, y, z);
		float brightness = 1.0f;
		if (LightmapHelper.isLightmapEnabled()) {
			tessellator.setLightmapCoord(this.block.getLightmapCoord(BlockModelCropsWheat.renderBlocks.blockAccess, x, y, z));
		} else {
			brightness = this.getBlockBrightness(BlockModelCropsWheat.renderBlocks.blockAccess, x, y, z);
		}
		tessellator.setColorOpaque_F(brightness, brightness, brightness);
		IconCoordinate texture = this.getBlockTextureFromSideAndMetadata(Side.BOTTOM, BlockModelCropsWheat.renderBlocks.blockAccess.getBlockMetadata(x, y, z));
		if (BlockModelCropsWheat.renderBlocks.overrideBlockTexture != null) {
			texture = BlockModelCropsWheat.renderBlocks.overrideBlockTexture;
		}
		double uMin = texture.getIconUMin();
		double uMax = texture.getIconUMax();
		double vMin = texture.getIconVMin();
		double vMax = texture.getIconVMax();
		double xMin = (double) x + 0.5 - 0.25;
		double xMax = (double) x + 0.5 + 0.25;
		double zMin = (double) z + 0.5 - 0.5;
		double zMax = (double) z + 0.5 + 0.5;
		double yd = (float) y - 0.0625f;
		tessellator.addVertexWithUV(xMin, yd + 1.0, zMin, uMin, vMin);
		tessellator.addVertexWithUV(xMin, yd + 0.0, zMin, uMin, vMax);
		tessellator.addVertexWithUV(xMin, yd + 0.0, zMax, uMax, vMax);
		tessellator.addVertexWithUV(xMin, yd + 1.0, zMax, uMax, vMin);
		tessellator.addVertexWithUV(xMin, yd + 1.0, zMax, uMin, vMin);
		tessellator.addVertexWithUV(xMin, yd + 0.0, zMax, uMin, vMax);
		tessellator.addVertexWithUV(xMin, yd + 0.0, zMin, uMax, vMax);
		tessellator.addVertexWithUV(xMin, yd + 1.0, zMin, uMax, vMin);
		tessellator.addVertexWithUV(xMax, yd + 1.0, zMax, uMin, vMin);
		tessellator.addVertexWithUV(xMax, yd + 0.0, zMax, uMin, vMax);
		tessellator.addVertexWithUV(xMax, yd + 0.0, zMin, uMax, vMax);
		tessellator.addVertexWithUV(xMax, yd + 1.0, zMin, uMax, vMin);
		tessellator.addVertexWithUV(xMax, yd + 1.0, zMin, uMin, vMin);
		tessellator.addVertexWithUV(xMax, yd + 0.0, zMin, uMin, vMax);
		tessellator.addVertexWithUV(xMax, yd + 0.0, zMax, uMax, vMax);
		tessellator.addVertexWithUV(xMax, yd + 1.0, zMax, uMax, vMin);
		xMin = (double) x + 0.5 - 0.5;
		xMax = (double) x + 0.5 + 0.5;
		zMin = (double) z + 0.5 - 0.25;
		zMax = (double) z + 0.5 + 0.25;
		tessellator.addVertexWithUV(xMin, yd + 1.0, zMin, uMin, vMin);
		tessellator.addVertexWithUV(xMin, yd + 0.0, zMin, uMin, vMax);
		tessellator.addVertexWithUV(xMax, yd + 0.0, zMin, uMax, vMax);
		tessellator.addVertexWithUV(xMax, yd + 1.0, zMin, uMax, vMin);
		tessellator.addVertexWithUV(xMax, yd + 1.0, zMin, uMin, vMin);
		tessellator.addVertexWithUV(xMax, yd + 0.0, zMin, uMin, vMax);
		tessellator.addVertexWithUV(xMin, yd + 0.0, zMin, uMax, vMax);
		tessellator.addVertexWithUV(xMin, yd + 1.0, zMin, uMax, vMin);
		tessellator.addVertexWithUV(xMax, yd + 1.0, zMax, uMin, vMin);
		tessellator.addVertexWithUV(xMax, yd + 0.0, zMax, uMin, vMax);
		tessellator.addVertexWithUV(xMin, yd + 0.0, zMax, uMax, vMax);
		tessellator.addVertexWithUV(xMin, yd + 1.0, zMax, uMax, vMin);
		tessellator.addVertexWithUV(xMin, yd + 1.0, zMax, uMin, vMin);
		tessellator.addVertexWithUV(xMin, yd + 0.0, zMax, uMin, vMax);
		tessellator.addVertexWithUV(xMax, yd + 0.0, zMax, uMax, vMax);
		tessellator.addVertexWithUV(xMax, yd + 1.0, zMax, uMax, vMin);
		return true;
	}

	@Override
	public boolean shouldItemRender3d() {
		return false;
	}

}

