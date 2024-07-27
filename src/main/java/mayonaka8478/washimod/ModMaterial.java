package mayonaka8478.washimod;

import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;

public class ModMaterial extends Material {
	public static final Material bamboo_shoot = new ModMaterial(MaterialColor.none).notAlwaysDestroyable();
	private boolean alwaysDestroyable;

	public ModMaterial(MaterialColor color) {
		super(color);
	}

	private Material notAlwaysDestroyable() {
		this.alwaysDestroyable = false;
		return this;
	}

	@Override
	public boolean isAlwaysDestroyable() {
		return this.alwaysDestroyable;
	}
}
