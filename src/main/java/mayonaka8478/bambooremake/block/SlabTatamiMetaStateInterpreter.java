package mayonaka8478.bambooremake.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.WorldSource;
import org.useless.dragonfly.model.blockstates.processed.MetaStateInterpreter;

import java.util.HashMap;

public class SlabTatamiMetaStateInterpreter extends MetaStateInterpreter {

	@Override
	public HashMap<String, String> getStateMap(WorldSource worldSource, int x, int y, int z, Block block, int meta) {
		int hRotation = meta & 2;
		int vRotation = meta & 5;
		HashMap<String, String> result = new HashMap<>();
		result.put("half", new String[]{"bottom", "double", "top"}[hRotation]);
		result.put("facing", vRotation == 0 ? "x" : "z");
		return result;
	}
}