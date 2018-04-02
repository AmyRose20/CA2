package main.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader 
{
	// Constructor
	public static BufferedImage loadImage(String path)
	{
		try
		{
			// This will read an image from a file path specified, passed as a string
			return ImageIO.read(ImageLoader.class.getResource(path));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			// If image cannot be loaded, the game will not run
			System.exit(1);
		}
		return null;
	}
}
