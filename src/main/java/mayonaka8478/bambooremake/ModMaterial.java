package mayonaka8478.bambooremake;

import mayonaka8478.bambooremake.mixin.MaterialMixin;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;

public class ModMaterial {
	public static final Material bamboo_shoot = ((MaterialMixin) new Material(MaterialColor.none)).notAlwaysDestroyable();
}
