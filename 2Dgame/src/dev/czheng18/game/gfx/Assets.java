package dev.czheng18.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int WIDTH = 32, HEIGHT = 32;
	public static BufferedImage dirt, grass, stone, tree;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_stand, player_leftAttack,
			player_rightAttack, player_aura;
	public static BufferedImage[] btn_start;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/texture.png"));

		btn_start = new BufferedImage[2];

		player_aura = new BufferedImage[3];
		player_leftAttack = new BufferedImage[3];
		player_rightAttack = new BufferedImage[3];
		player_stand = new BufferedImage[1];
		player_down = new BufferedImage[3];
		player_up = new BufferedImage[3];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];

		btn_start[0] = sheet.crop(WIDTH * 2, HEIGHT, WIDTH * 2, HEIGHT);
		btn_start[1] = sheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH * 2, HEIGHT);

		player_aura[0] = sheet.crop(WIDTH * 4, HEIGHT * 6, WIDTH, HEIGHT);
		player_aura[1] = sheet.crop(WIDTH * 5, HEIGHT * 6, WIDTH, HEIGHT);
		player_aura[2] = sheet.crop(WIDTH * 6, HEIGHT * 6, WIDTH, HEIGHT);

		player_leftAttack[0] = sheet.crop(WIDTH * 4, HEIGHT * 4, WIDTH, HEIGHT);
		player_leftAttack[1] = sheet.crop(WIDTH * 5, HEIGHT * 4, WIDTH, HEIGHT);
		player_leftAttack[2] = sheet.crop(WIDTH * 6, HEIGHT * 4, WIDTH, HEIGHT);

		player_rightAttack[0] = sheet.crop(WIDTH * 4, HEIGHT * 5, WIDTH, HEIGHT);
		player_rightAttack[1] = sheet.crop(WIDTH * 5, HEIGHT * 5, WIDTH, HEIGHT);
		player_rightAttack[2] = sheet.crop(WIDTH * 6, HEIGHT * 5, WIDTH, HEIGHT);

		player_stand[0] = sheet.crop(WIDTH * 5, 0, WIDTH, HEIGHT);

		player_down[0] = sheet.crop(WIDTH * 4, 0, WIDTH, HEIGHT);
		player_down[1] = sheet.crop(WIDTH * 5, 0, WIDTH, HEIGHT);
		player_down[2] = sheet.crop(WIDTH * 6, 0, WIDTH, HEIGHT);

		player_left[0] = sheet.crop(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);
		player_left[1] = sheet.crop(WIDTH * 5, HEIGHT, WIDTH, HEIGHT);
		player_left[2] = sheet.crop(WIDTH * 6, HEIGHT, WIDTH, HEIGHT);

		player_right[0] = sheet.crop(WIDTH * 4, HEIGHT * 2, WIDTH, HEIGHT);
		player_right[1] = sheet.crop(WIDTH * 5, HEIGHT * 2, WIDTH, HEIGHT);
		player_right[2] = sheet.crop(WIDTH * 6, HEIGHT * 2, WIDTH, HEIGHT);

		player_up[0] = sheet.crop(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT);
		player_up[1] = sheet.crop(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT);
		player_up[2] = sheet.crop(WIDTH * 6, HEIGHT * 3, WIDTH, HEIGHT);

		dirt = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		grass = sheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		stone = sheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);
		tree = sheet.crop(0, HEIGHT, WIDTH, HEIGHT);

	}
}
