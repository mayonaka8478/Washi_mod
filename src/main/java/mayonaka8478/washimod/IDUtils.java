package mayonaka8478.washimod;

public class IDUtils {
	private static int curr_plants_block_id = 0;
	private static int curr_building_block_id = 0;
	private static int curr_others_block_id = 0;
	private static int curr_plants_item_id = 0;
	private static int curr_tools_item_id = 0;
	private static int curr_foods_item_id = 0;
	private static int curr_others_item_id = 0;


	public static void initIds(int BlockIdPlants, int BlockIdBuilding, int BlockIdOthers, int ItemIdPlants, int ItemIdTools, int ItemIdOthers, int ItemIdFoods) {
		curr_plants_block_id = BlockIdPlants;
		curr_building_block_id = BlockIdBuilding;
		curr_others_block_id = BlockIdOthers;
		curr_plants_item_id = ItemIdPlants;
		curr_tools_item_id = ItemIdTools;
		curr_foods_item_id = ItemIdFoods;
		curr_others_item_id = ItemIdOthers;
	}

	public static int getCurrPlantsBlockId() {
		return curr_plants_block_id++;
	}

	public static int getCurrBuildingBlockId() {
		return curr_building_block_id++;
	}

	public static int getCurrOthersBlockId() {
		return curr_others_block_id++;
	}

	public static int getCurrPlantsItemId() {
		return curr_plants_item_id++;
	}

	public static int getCurrToolsItemId() {
		return curr_tools_item_id++;
	}

	public static int getCurrFoodsItemId() {
		return curr_foods_item_id++;
	}

	public static int getCurrOthersItemId() {
		return curr_others_item_id++;
	}
}
