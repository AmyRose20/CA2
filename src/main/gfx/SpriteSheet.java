package main.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet 
{
	// Data
	public BufferedImage sheet;
	
	// Constructor
	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}
	
	// Method
	/* Will return a section of the sprite sheet
	   and not the entire sheet */
	public BufferedImage crop(int x, int y, int width, int height)
	{
		/* 'getSubimage' is a function within the 'BufferedImage' class
		will return a portion of the sprite sheet specified with the parameters passed */
		return sheet.getSubimage(x, y, width, height);	
	}
}
