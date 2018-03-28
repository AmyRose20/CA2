package main.gfx;

import java.awt.image.BufferedImage;
/* This class is used so that all the images are loaded once
   and not continuously through the 'render' function in the
   "Game" class as this is inefficient */
public class Assets 
{
	private static final int width = 157, height = 157;
	public static BufferedImage player;
	public static BufferedImage ground;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		SpriteSheet  terrain = new SpriteSheet(ImageLoader.loadImage("/textures/terrain.png"));
		
		player = sheet.crop(0, 0, width, height);
		ground = terrain.crop(0, 360, 80, 23);
	}
}
