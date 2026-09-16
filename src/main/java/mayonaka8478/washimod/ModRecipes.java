package mayonaka8478.washimod;

import net.minecraft.core.data.DataLoader;
import turniplabs.halplibe.helper.RecipeBuilder;

import static mayonaka8478.washimod.WashiMod.MOD_ID;

public class ModRecipes {
	public static void onRecipesReady() {
		DataLoader.loadRecipesFromFile("/assets/" + MOD_ID + "/recipes/workbench.json");
	}

	public static void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}
}
