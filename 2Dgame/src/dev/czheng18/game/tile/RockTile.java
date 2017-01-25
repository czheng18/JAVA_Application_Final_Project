package dev.czheng18.game.tile;

import dev.czheng18.game.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.stone, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
