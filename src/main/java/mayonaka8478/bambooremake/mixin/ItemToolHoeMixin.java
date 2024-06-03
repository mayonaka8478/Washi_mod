package mayonaka8478.bambooremake.mixin;

import mayonaka8478.bambooremake.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolHoe;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemToolHoe.class, remap = false)
public class ItemToolHoeMixin extends ItemTool {

	protected ItemToolHoeMixin(String name, int id, int damageDealt, ToolMaterial toolMaterial, Tag<Block> tagEffectiveAgainst) {
		super(name, id, damageDealt, toolMaterial, tagEffectiveAgainst);
	}

	@Inject(method = "onBlockDestroyed", at = @At("HEAD"))
	public void onBlockDestroyed(World world, ItemStack itemstack, int id, int x, int y, int z, EntityLiving entity, CallbackInfoReturnable<Boolean> cir) {
		if (id == ModBlocks.bamboo_shoot.id && entity != null) {
			itemstack.damageItem(8, entity);
		}
	}
}
