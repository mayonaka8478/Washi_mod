package mayonaka8478.washimod.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.IAccumulatable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlockSlab;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemBlockSlabTatami<T extends BlockLogic> extends ItemBlockSlab<T> {
	public ItemBlockSlabTatami(@NotNull Block<T> block) {
		super(block);
	}

	@Override
	public boolean canAccumulateInto(@NotNull ItemStack selfStack, @NotNull Block<?> block, int data, @NotNull Side side, double xHit, double yHit) {
		return super.canAccumulateInto(selfStack, block, data & 0b11, side, xHit, yHit);
	}

	@Override
	public @NotNull IAccumulatable.BlockDataResult getAccumulationResult(
		@NotNull ItemStack selfStack,
		@NotNull World world,
		@Nullable Player player,
		@NotNull TilePosc tilePos,
		@NotNull Side side,
		double xHit,
		double yHit,
		@NotNull IAccumulatable.BlockDataResult result
	) {
		int rotationBit = world.getBlockData(tilePos) & 0b100;
		result.data = 1 | rotationBit;
		result.bounds.setMin(0.0, 0.0, 0.0).setMax(1.0, 1.0, 1.0);
		return result;
	}
}
