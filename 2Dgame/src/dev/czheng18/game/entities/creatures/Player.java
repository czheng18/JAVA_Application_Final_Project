package dev.czheng18.game.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.czheng18.game.Handler;
import dev.czheng18.game.entities.Entity;
import dev.czheng18.game.gfx.Animation;
import dev.czheng18.game.gfx.Assets;
import dev.czheng18.game.inventory.Inventory;

public class Player extends Creature {

	// Animations
	private Animation animDown, animUp, animLeft, animRight, animStand, animleftAttack, animrightAttack, animAura;
	// Attack timer
	private long lastAttackTimer, attackCooldown = 200, attackTimer = attackCooldown;
	// Inventory
	private Inventory inventory;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFFAULT_CREATURE_WIDTH, Creature.DEFFAULT_CREATURE_HEIGHT);

		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;

		// Animations
		animStand = new Animation(200, Assets.player_stand);
		animDown = new Animation(200, Assets.player_down);
		animUp = new Animation(200, Assets.player_up);
		animRight = new Animation(200, Assets.player_right);
		animLeft = new Animation(200, Assets.player_left);
		animleftAttack = new Animation(200, Assets.player_leftAttack);
		animrightAttack = new Animation(200, Assets.player_rightAttack);
		animAura = new Animation(200, Assets.player_aura);
		inventory = new Inventory(handler);

	}

	@Override
	public void tick() {
		// Animations
		animleftAttack.tick();
		animrightAttack.tick();
		animStand.tick();
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		animAura.tick();
		// Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		// Attack
		checkAttacks();
		// Inventory
		inventory.tick();
	}

	public void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown)
			return;

		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;

		if (handler.getKeyManager().aUp) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		} else if (handler.getKeyManager().aDown) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - cb.height;
		} else if (handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if (handler.getKeyManager().aRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else {
			return;
		}

		attackTimer = 0;

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(1);
				return;
			}

		}
	}

	public void dies() {
		System.out.println("You lose");
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		inventory.render(g);
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else if (handler.getKeyManager().aLeft) {
			return animleftAttack.getCurrentFrame();
		} else if (handler.getKeyManager().aRight) {
			return (animrightAttack.getCurrentFrame());
		} else if (handler.getKeyManager().aUp) {
			return (animAura.getCurrentFrame());
		} else
			return animStand.getCurrentFrame();

	}

}
