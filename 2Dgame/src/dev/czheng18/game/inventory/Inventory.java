package dev.czheng18.game.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.czheng18.game.Handler;
import dev.czheng18.game.items.item;

public class Inventory {

	private Handler handler;
	private boolean active = false;
	private ArrayList<item> inventoryItems;

	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<item>();
	}

	public void tick() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if (!active)
			return;

		System.out.println("INVENTORY:");
		for (item i : inventoryItems) {
			System.out.println(i.getName() + " " + i.getCount());
		}

	}

	public void render(Graphics g) {
		if (!active)
			return;
	}
	// Inventory methods

	public void addItem(item items) {
		for (item i : inventoryItems) {
			if (i.getId() == items.getId()) {
				i.setCount(i.getCount() + items.getCount());
				return;
			}
		}
		inventoryItems.add(items);
	}

	// GETTERS SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
