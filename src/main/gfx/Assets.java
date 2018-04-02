package main.gfx;

import java.awt.image.BufferedImage;
/* This class is used so that all the IMAGES are LOADED ONCE
   and not continuously through the 'render' function in the
   'Game' class as this is inefficient */
public class Assets 
{
	// Data
	
	private static int width = 157, height = 157;
	// Is an array as, the images will be continuously looped through
	public static BufferedImage[] player;
	public static BufferedImage grass, brick, flower;
	public static BufferedImage tree;
	
	public static void init()
	{
		// Path to image will be passed as a string firstly to the ImageLoader class
		// It will then return as a 'Spritesheet' object which is a 'BufferedImage'
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		SpriteSheet terrain = new SpriteSheet(ImageLoader.loadImage("/textures/terrain.png"));
		SpriteSheet tree1 = new SpriteSheet(ImageLoader.loadImage("/textures/tree1.png"));
		
		// Twelve images will be looped through to create animation
		player = new BufferedImage[12];
		
		// Sections of the terrain image cropped to retrieve a sub-image within the sprite sheet 
		grass = terrain.crop(0, 360, 80, 23);
		brick = terrain.crop(360, 480, 40, 30);
		flower = terrain.crop(288, 355, 30, 15);
		
		tree = tree1.crop(0, 0, 800, 800);
		
		/* This is each sub-image of the player within the sprite sheet that
		   will be looped through to give the appearance that the player
		   is moving */
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
