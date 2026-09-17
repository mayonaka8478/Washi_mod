package mayonaka8478.washimod;

import net.fabricmc.api.ClientModInitializer;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.util.dependency.Key;

import static mayonaka8478.washimod.WashiMod.MOD_ID;

public class WashiModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientEvents.BEFORE_CLIENT_START.listen(Key.of(MOD_ID), WashiModClient::beforeClientStart);
		ClientEvents.AFTER_CLIENT_START.listen(Key.of(MOD_ID), WashiModClient::afterClientStart);
		ClientEvents.BLOCK_MODEL_RELOAD.listen(Key.of(MOD_ID), ModModels::initBlockModels);
		ClientEvents.ITEM_MODEL_RELOAD.listen(Key.of(MOD_ID), ModModels::initItemModels);
	}

	private static void beforeClientStart() {

	}


	private static void afterClientStart() {

	}
}
