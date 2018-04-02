package main.tiles;

import main.gfx.Assets;

public class GrassTile extends Tile
{
	// Constructor
	public GrassTile(int id) 
	{
		// Assets.grass achieved as the grass BufferedImage is static and public so it may be accessed
		// id received through the parent class 'Tile'
		super(Assets.grass, id);
	}
	
	// Method
	// The tile is !solid, so the player may move into it and will not collide with this object
	public boolean isSolid()
	{
		return false;
	}
}