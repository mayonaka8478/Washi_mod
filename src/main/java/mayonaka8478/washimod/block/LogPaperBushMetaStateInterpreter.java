package mayonaka8478.washimod.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockAxisAligned;
import net.minecraft.core.world.WorldSource;
import org.useless.dragonfly.model.blockstates.processed.MetaStateInterpreter;

import java.util.HashMap;

public class LogPaperBushMetaStateInterpreter extends MetaStateInterpreter {

	@Override
	public HashMap<String, String> getStateMap(WorldSource worldSource, int x, int y, int z, Block block, int meta) {
		HashMap<String, String> result = new HashMap<>();
		int Alt = meta & 0b101;
		result.put("axis", String.valueOf(BlockAxisAligned.metaToAxis(meta)).toLowerCase());
		result.put("alt", new String[]{"x", "z", "a"}[Alt]);
		return result;
	}
}
