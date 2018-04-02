package main.tiles;

import main.gfx.Assets;

public class BrickTile extends Tile 
{
	// Constructor
	public BrickTile(int id) 
	{
		// Assets.brick achieved as the grass BufferedImage is static and public so it may be accessed
		// id received through the parent class 'Tile'
		super(Assets.brick, id);
	}
	
	// Method
	// The tile is solid, so the player may not move into it and will collide with this object
	public boolean isSolid()
	{
		return true;
	}
}
