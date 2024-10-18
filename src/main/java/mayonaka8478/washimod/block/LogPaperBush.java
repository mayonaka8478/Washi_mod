package mayonaka8478.washimod.block;

public class LogPaperBush {

	//ブロック隣接時に透けて見えるのを阻止するやつ
	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

}
