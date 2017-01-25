package dev.czheng18.game.states;

import java.awt.Graphics;

import dev.czheng18.game.Handler;
import dev.czheng18.game.worlds.World;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world.txt");
		handler.setWorld(world);

	}

	@Override
	public void tick() {
		world.tick();

	}

	@Override
	public void render(Graphics g) {
		world.render(g);

	}

}
