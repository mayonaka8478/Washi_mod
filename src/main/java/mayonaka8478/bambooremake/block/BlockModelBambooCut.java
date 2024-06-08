package mayonaka8478.bambooremake.block;

import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.block.model.BlockModelAxisAligned;
import net.minecraft.client.render.block.model.BlockModelCropsWheat;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockRotatable;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.helper.Sides;

public class BlockModelBambooCut<T extends Block>
	extends BlockModelStandard<T> {

	public BlockModelBambooCut(Block block) {
		super(block);
	}

	@Override
	public boolean render(Tessellator tessellator, int x, int y, int z) {
		this.block.setBlockBoundsBasedOnState(BlockModelCropsWheat.renderBlocks.blockAccess, x, y, z);
		int l = BlockModelAxisAligned.renderBlocks.blockAccess.getBlockMetadata(x, y, z);
		int i1 = BlockRotatable.getOrientation(l);
		switch (i1) {
			case 0: {
				BlockModelAxisAligned.renderBlocks.uvRotateEast = 0;
				BlockModelAxisAligned.renderBlocks.uvRotateWest = 0;
				BlockModelAxisAligned.renderBlocks.uvRotateSouth = 0;
				BlockModelAxisAligned.renderBlocks.uvRotateNorth = 0;
				break;
			}
			case 1: {
				BlockModelAxisAligned.renderBlocks.uvRotateSouth = 1;
				BlockModelAxisAligned.renderBlocks.uvRotateNorth = 1;
				break;
			}
			case 2: {
				BlockModelAxisAligned.renderBlocks.uvRotateEast = 1;
				BlockModelAxisAligned.renderBlocks.uvRotateWest = 1;
				BlockModelAxisAligned.renderBlocks.uvRotateTop = 1;
				BlockModelAxisAligned.renderBlocks.uvRotateBottom = 1;
			}
		}
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
	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		if (6 * (data & 3) + side.getId() >= Sides.orientationLookUpXYZAligned.length) {
			return TextureRegistry.getTexture("minecraft:block/grass_top");
		}
		return this.atlasIndices[Sides.orientationLookUpXYZAligned[6 * (data & 3) + side.getId()]];
	}

	@Override
	public boolean shouldItemRender3d() {
		return false;
	}

}
