package dev.czheng18.game.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.czheng18.game.Handler;

public class ItemManager {

	private Handler handler;
	private ArrayList<item> items;

	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<item>();
	}

	public void tick() {
		Iterator<item> it = items.iterator();
		while (it.hasNext()) {
			item i = it.next();
			i.tick();
			if (i.isPickedUp())
				it.remove();
		}
	}

	public void render(Graphics g) {
		for (item i : items)
			i.render(g);
	}

	public void addItem(item i) {
		i.setHandler(handler);
		items.add(i);
	}

	// GETTERS SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<item> getItems() {
		return items;
	}

	public void setItems(ArrayList<item> items) {
		this.items = items;
	}
}
