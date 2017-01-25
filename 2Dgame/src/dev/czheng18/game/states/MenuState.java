package dev.czheng18.game.states;

import java.awt.Graphics;

import dev.czheng18.game.Handler;
import dev.czheng18.game.gfx.Assets;
import dev.czheng18.game.ui.ClickListener;
import dev.czheng18.game.ui.UIImageButton;
import dev.czheng18.game.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
