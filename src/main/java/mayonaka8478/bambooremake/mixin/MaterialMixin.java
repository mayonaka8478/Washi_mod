package mayonaka8478.bambooremake.mixin;

import net.minecraft.core.block.material.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = Material.class, remap = false)
public interface MaterialMixin {
	@Invoker("notAlwaysDestroyable")
	public Material notAlwaysDestroyable();
}
