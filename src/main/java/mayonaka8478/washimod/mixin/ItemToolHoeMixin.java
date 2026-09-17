package mayonaka8478.washimod.mixin;

import mayonaka8478.washimod.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolHoe;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemToolHoe.class, remap = false)
public abstract class ItemToolHoeMixin extends ItemTool {

	protected ItemToolHoeMixin(@NotNull String name, @NotNull String namespaceId, int id, int damageDealt, @NotNull ToolMaterial toolMaterial, @NotNull Tag<Block<?>> tagEffectiveAgainst) {
		super(name, namespaceId, id, damageDealt, toolMaterial, tagEffectiveAgainst);
	}

	@Inject(method = "onBlockDestroyed", at = @At("HEAD"))
	public void onBlockDestroyed(@NotNull ItemStack selfStack, @NotNull World world, @NotNull Mob mob, @NotNull Block<?> removedBlock, @NotNull TilePosc blockPos, @NotNull Side side, CallbackInfoReturnable<Boolean> cir) {
		if (!world.isClientSide && removedBlock == ModBlocks.bamboo_shoot) {
			selfStack.damageItem(8, mob);
		}
	}
}
