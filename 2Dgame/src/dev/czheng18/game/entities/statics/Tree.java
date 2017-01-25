package dev.czheng18.game.entities.statics;

import java.awt.Graphics;

import dev.czheng18.game.Handler;
import dev.czheng18.game.gfx.Assets;
import dev.czheng18.game.items.item;
import dev.czheng18.game.tile.Tile;

public class Tree extends StaticEntity {
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);

		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {

	}

	@Override
	public void dies() {
		handler.getWorld().getItemManager().addItem(item.woodItem.creatNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
}
