package mayonaka8478.bambooremake.item;

import mayonaka8478.bambooremake.BambooRemake;
import mayonaka8478.bambooremake.IDUtils;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;

public class ModItems {
	public static final Item bamboo = new ItemBuilder(BambooRemake.MOD_ID).build(new Item("bamboo", IDUtils.getCurrItemId()));

	public static void createitems() {

	}
}
