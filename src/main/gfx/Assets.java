package main.gfx;

import java.awt.image.BufferedImage;
/* This class is used so that all the images are loaded once
   and not continuously through the 'render' function in the
   "Game" class as this is inefficient */
public class Assets 
{
	private static final int width = 157, height = 157;
	public static BufferedImage[] player;
	public static BufferedImage grass, brick, flowers;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		SpriteSheet  terrain = new SpriteSheet(ImageLoader.loadImage("/textures/terrain.png"));
		
		player = new BufferedImage[12];
		
		grass = terrain.crop(0, 360, 80, 23);
		brick = terrain.crop(360, 480, 40, 30);
		flowers = terrain.crop(288, 355, 62, 29);
		
		player[0] = sheet.crop(0, 0, width, height);
		player[1] = sheet.crop(width, 0, width, height);
		player[2] = sheet.crop(width * 2, 0, width, height);
		player[3] = sheet.crop(width * 3, 0, width, height);
		
		player[4] = sheet.crop(0, height, width, height);
		player[5] = sheet.crop(width, height, width, height);
        player[6] = sheet.crop(width * 2, 0, height, height);
		player[7] = sheet.crop(width * 3, height, width, height);
		
		player[8] = sheet.crop(0, height * 2, width, height);
		player[9] = sheet.crop(width, height * 2, width, height);
		player[10] = sheet.crop(width * 2, height * 2, width, height);
		player[11] = sheet.crop(width * 3, height * 2, width, height);
	}
}
