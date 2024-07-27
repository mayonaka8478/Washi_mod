package mayonaka8478.washimod.item;

import mayonaka8478.washimod.IDUtils;
import mayonaka8478.washimod.WashiMod;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;

public class ModItems {
	public static final Item bamboo = new ItemBuilder(WashiMod.MOD_ID).build(new Item("bamboo", IDUtils.getCurrItemId()));

	public static void createItems() {

	}
}
