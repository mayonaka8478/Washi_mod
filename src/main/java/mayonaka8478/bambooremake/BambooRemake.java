package mayonaka8478.bambooremake;

import mayonaka8478.bambooremake.block.ModBlocks;
import mayonaka8478.bambooremake.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class BambooRemake implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
	public static final String MOD_ID = "bambooremake";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id", "8401");
		prop.setProperty("starting_item_id", "28401");
		ConfigHandler config = new ConfigHandler(MOD_ID, prop);
		IDUtils.initIds(
			config.getInt("starting_block_id"),
			config.getInt("starting_item_id"));
		config.updateConfig();
	}
    @Override
    public void onInitialize() {
		LOGGER.info("Bamboo Remake");
    }

	@Override
	public void beforeGameStart() {
		ModBlocks.createBlocks();
		ModItems.createitems();
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
