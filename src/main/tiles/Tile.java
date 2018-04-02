package main.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	// Data
	
	/* This tile array will use twenty tiles of type'GrassTile'
	   'BrickTile', which will be specified by there ids */
	public static Tile[] tiles = new Tile[20];
	// 0 is the id
	/* All tiles have a unique id, so that they can be rendered on the screen
	   when loading the world */
	
	public static Tile GrassTile = new GrassTile(0);
	public static Tile brickTile = new BrickTile(1);
	
	public static int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected int id;
	
	// Constructor
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		
		/* id must be specified in index 
		   to know what tile to load into the world */
		tiles[id] = this;
	}
	
	// Methods
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	/* Default value is false. Attempted to make this
	   an abstract method, though that is not allowed.
	   This method will be present in the 'GrassTile'
	   child class containing a value of true rather than false */
	public boolean isSolid()
	{
		return false;
	}
	
	 // Getter
	public int getId()
	{
		return id;
	}
}
