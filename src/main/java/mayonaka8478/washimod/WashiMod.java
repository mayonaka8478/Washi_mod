package mayonaka8478.washimod;

import mayonaka8478.washimod.block.ModBlocks;
import mayonaka8478.washimod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class WashiMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
	public static final String MOD_ID = "washimod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id_plants", "8401");
		prop.setProperty("starting_block_id_building", "8501");
		prop.setProperty("starting_block_id_others", "8701");
		prop.setProperty("starting_item_id_plants", "28401");
		prop.setProperty("starting_item_id_tools", "28501");
		prop.setProperty("starting_item_id_foods", "28601");
		prop.setProperty("starting_item_id_others", "28701");
		ConfigHandler config = new ConfigHandler(MOD_ID, prop);
		IDUtils.initIds(
			config.getInt("starting_block_id_plants"),
			config.getInt("starting_block_id_building"),
			config.getInt("starting_block_id_others"),
			config.getInt("starting_item_id_plants"),
			config.getInt("starting_item_id_tools"),
			config.getInt("starting_item_id_plants"),
			config.getInt("starting_item_id_others"));

		config.updateConfig();
	}
    @Override
    public void onInitialize() {
		LOGGER.info("Washi Mod");
    }

	@Override
	public void beforeGameStart() {
		ModBlocks.createBlocks();
		ModItems.createItems();
	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {

	}
}
