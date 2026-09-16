package mayonaka8478.washimod.item;

import mayonaka8478.washimod.IDUtils;
import mayonaka8478.washimod.WashiMod;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

public class ModItems {
	public static Item bamboo;

	public static void createItems() {
		CreativeInventoryPlacement.Category categoryMisc = new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS);

		bamboo = new ItemBuilder(WashiMod.MOD_ID)
			.setCreativeInventoryPlacement(categoryMisc)
			.build(new Item("bamboo", WashiMod.MOD_ID + ":item/bamboo", IDUtils.getCurrPlantsItemId()));
	}
}
