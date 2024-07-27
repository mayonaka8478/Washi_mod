package mayonaka8478.washimod;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static mayonaka8478.washimod.WashiMod.MOD_ID;

public class ModRecipe implements RecipeEntrypoint {
	public static final RecipeNamespace BAMBOO = new RecipeNamespace();
	public static final RecipeGroup<RecipeEntryCrafting<?, ?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.workbench)));

	@Override
	public void onRecipesReady() {
		BAMBOO.register("workbench", WORKBENCH);
		Registries.RECIPES.register(MOD_ID, BAMBOO);
		DataLoader.loadRecipesFromFile("/assets/washimod/recipes/workbench.json");
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}
}
