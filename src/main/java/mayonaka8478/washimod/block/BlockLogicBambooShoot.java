package mayonaka8478.washimod.block;

import mayonaka8478.washimod.ModMaterials;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBdc;

import java.util.Random;

public class BlockLogicBambooShoot extends BlockLogic {
	public BlockLogicBambooShoot(@NotNull Block<?> block) {
		super(block, ModMaterials.BAMBOO_SHOOT);
		float f = 0.2f;
		this.setBlockBounds(0.5f - f, 0.0, 0.5f - f, 0.5f + f, f * 3.0f, 0.5f + f);
	}

	@Override
	public void updateTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand, boolean isRandomTick) {
		if (world.getSavedLightValue(LightLayer.Block, tilePos) >= 13) {
			int data = world.getBlockData(tilePos);
			if (data == 15) {
				world.setBlockTypeNotify(tilePos, ModBlocks.bamboo);
			} else {
				world.setBlockDataNotify(tilePos, data + 1);
			}
		}
	}

	@Override
	public AABBdc getCollisionAABB(@NotNull WorldSource world, @NotNull TilePosc tilePos) {
		return null;
	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean isCubeShaped() {
		return false;
	}

	@Override
	public boolean canPlaceAt(@NotNull World world, @NotNull TilePosc tilePos) {
		return super.canPlaceAt(world, tilePos) && this.canGrowOn(world.getBlockType(tilePos.add(Direction.DOWN, new TilePos())));
	}

	@Override
	public boolean canStay(@NotNull World world, @NotNull TilePosc tilePos) {
		return world.canBlockSeeSky(tilePos) && this.canGrowOn(world.getBlockType(tilePos.add(Direction.DOWN, new TilePos())));
	}

	protected boolean canGrowOn(@NotNull Block<?> block) {
		return block.hasTag(BlockTags.GROWS_FLOWERS);
	}

	@Override
	public void onNeighborChanged(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Block<?> block) {
		super.onNeighborChanged(world, tilePos, block);
		if (!this.canStay(world, tilePos)) {
			this.dropWithCause(world, EnumDropCause.WORLD, tilePos, world.getBlockData(tilePos), null, null);
			world.setBlockTypeNotify(tilePos, Blocks.AIR);
		}
	}

	@Override
	public boolean renderAsNormalBlockOnCondition(@NotNull WorldSource source, @NotNull TilePosc tilePos) {
		return false;
	}

	@Override
	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, @NotNull TilePosc tilePos, int meta, TileEntity tileEntity) {
		return switch (dropCause) {
			case PROPER_TOOL, PICK_BLOCK ->
				new ItemStack[]{new ItemStack(this)};
			default ->
				null;
		};
	}

}
