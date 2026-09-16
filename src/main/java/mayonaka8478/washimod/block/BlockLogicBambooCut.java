package mayonaka8478.washimod.block;

import mayonaka8478.washimod.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicAxisAligned;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Axis;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;

public class BlockLogicBambooCut extends BlockLogicAxisAligned {
	public BlockLogicBambooCut(@NotNull Block<?> block) {
		super(block, Materials.VEGETABLE);
	}

	@Override
	public @NotNull AABBdc getBoundsFromState(@NotNull WorldSource world, @NotNull TilePosc tilePos) {
		float f = 0.375f;
		Axis axis = BlockLogicAxisAligned.metaToAxis(world.getBlockData(tilePos));
		return switch (axis) {
			case X -> new AABBd(0.0f, 0.5f - f, 0.5f - f, 1.0f, 0.5f + f, 0.5f + f);	// meta == 2 (EAST)
			case Z -> new AABBd(0.5f - f, 0.5f - f, 0.0f, 0.5f + f, 0.5f + f, 1.0f);	// meta == 1 (NORTH)
			default -> new AABBd(0.5f - f, 0.0F, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);	// meta == 0 (TOP)
		};
	}

	@Override
	public AABBdc getCollisionAABB(@NotNull WorldSource source, @NotNull TilePosc tilePos) {
		return null;
	}

	//ブロック隣接時に透けて見えるのを阻止するやつ
	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean isCubeShaped() {
		return false;
	}

	@Override
	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, @NotNull TilePosc tilePos, int meta, TileEntity tileEntity) {
		return switch (dropCause) {
			case SILK_TOUCH, PICK_BLOCK ->
				new ItemStack[]{new ItemStack(this)};
			default ->
				new ItemStack[]{new ItemStack(ModItems.bamboo, 4)};
		};
	}
}
