package dev.czheng18.game.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.czheng18.game.Handler;
import dev.czheng18.game.gfx.Assets;

public class item {

	// Handler

	public static item[] items = new item[256];
	public static item woodItem = new item(Assets.tree, "Wood", 0);

	// Class
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32, PICK_UP = -1;

	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;

	protected Rectangle bounds;
	protected int x, y, count;
	protected boolean pickedUp = false;

	public item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;

		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		items[id] = this;
	}

	public void tick() {
		if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
			pickedUp = true;
			handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}

	public void render(Graphics g) {
		if (handler == null)
			return;
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}

	public void render(Graphics g, int x, int y) {

		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}

	public item creatNew(int x, int y) {
		item i = new item(texture, name, id);
		i.setPostion(x, y);
		return i;
	}

	public void setPostion(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}

	// GEETHER SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}
}
