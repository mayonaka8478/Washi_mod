package mayonaka8478.washimod.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;

public class ItemBlockSlabTatami extends ItemBlock {
	public ItemBlockSlabTatami(Block block) {
		super(block);
	}
	@Override
	public boolean onUseItemOnBlock(ItemStack stack, EntityPlayer player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		int id = world.getBlockId(blockX, blockY, blockZ);
		byte rotateBit = (byte) (world.getBlockMetadata(blockX, blockY, blockZ) & 0b100);
		int meta = world.getBlockMetadata(blockX, blockY, blockZ) & 0b11;
		if (Block.blocksList[world.getBlockId(blockX, blockY, blockZ)] != null && Block.blocksList[world.getBlockId(blockX, blockY, blockZ)].hasTag(BlockTags.PLACE_OVERWRITES)) {
			id = 0;
			meta = 0;
		}
		if (stack.stackSize <= 0) {
			return false;
		}
		if (blockY == world.getHeightBlocks() - 1 && Block.blocksList[this.blockID].blockMaterial.isSolid()) {
			return false;
		}
		if (id == this.blockID && (side == Side.TOP && meta == 0 || side == Side.BOTTOM && meta == 2)) {
			AABB bbBox = AABB.getBoundingBoxFromPool(blockX, blockY, blockZ, (float)blockX + 1.0f, (float)blockY + 1.0f, (float)blockZ + 1.0f);
			if (!world.checkIfAABBIsClear(bbBox)) {
				return false;
			}
			Block blockSlab = Block.blocksList[this.blockID];
			world.setBlockMetadataWithNotify(blockX, blockY, blockZ, 0b1 | rotateBit);
			world.playBlockSoundEffect(player, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockSlab, EnumBlockSoundEffectType.PLACE);
			stack.consumeItem(player);
			return true;
		}
		if (id != 0) {
			id = world.getBlockId(blockX += side.getOffsetX(), blockY += side.getOffsetY(), blockZ += side.getOffsetZ());
			meta = world.getBlockMetadata(blockX, blockY, blockZ) & 0b11;
		}
		if (id == this.blockID && (yPlaced > 0.5 && meta == 0 || yPlaced <= 0.5 && meta == 2 || side == Side.BOTTOM && meta == 0 || side == Side.TOP && meta == 2)) {
			AABB bbBox = AABB.getBoundingBoxFromPool(blockX, blockY, blockZ, (float)blockX + 1.0f, (float)blockY + 1.0f, (float)blockZ + 1.0f);
			if (!world.checkIfAABBIsClear(bbBox)) {
				return false;
			}
			Block blockSlab = Block.blocksList[this.blockID];
			world.setBlockMetadataWithNotify(blockX, blockY, blockZ, 0b1 | rotateBit);
			world.playBlockSoundEffect(player, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, blockSlab, EnumBlockSoundEffectType.PLACE);
			stack.consumeItem(player);
			return true;
		}
		if (world.canBlockBePlacedAt(this.blockID, blockX, blockY, blockZ, false, side)) {
			Block block = Block.blocksList[this.blockID];
			if (world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, this.blockID, this.getPlacedBlockMetadata(stack.getMetadata()))) {
				Block.blocksList[this.blockID].onBlockPlaced(world, blockX, blockY, blockZ, side, player, yPlaced);
				world.playBlockSoundEffect(player, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, block, EnumBlockSoundEffectType.PLACE);
				stack.consumeItem(player);
			}
			return true;
		}
		return false;
	}
}
