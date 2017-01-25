package dev.czheng18.game.states;

import java.awt.Graphics;

import dev.czheng18.game.Handler;

public abstract class State {

	private static State currentState = null;

	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

	protected Handler handler;

	public State(Handler handler) {
		this.handler = handler;
	}

	// Class
	public abstract void tick();

	public abstract void render(Graphics g);

}
