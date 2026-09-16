package mayonaka8478.washimod.block;

import mayonaka8478.washimod.item.ItemBlockSlabTatami;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicSlab;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.util.helper.Axis;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

public class BlockLogicSlabTatami extends BlockLogicSlab {
	public BlockLogicSlabTatami(@NotNull Block<?> block, @NotNull Block<?> modelBlock) {
		super(block, modelBlock);
		block.setBlockItem(() -> new ItemBlockSlabTatami<>(block));
	}

	@Override
	public void onPlacedByMob(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side, @NotNull Mob mob, double xHit, double yHit) {
		Axis axis = mob.getHorizontalPlacementDirection(side).axis();
		Direction dir = mob.getVerticalPlacementDirection(side, yHit);
		int data = 0;
		if (dir == Direction.UP) {
			data = 0b10;
		}
		if (axis == Axis.Z) {
			data |= 0b100;
		}
		world.setBlockDataNotify(tilePos, data);
	}
}
