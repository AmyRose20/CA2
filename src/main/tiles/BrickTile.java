package main.tiles;

import main.gfx.Assets;

public class BrickTile extends Tile 
{
	public BrickTile(int id) 
	{
		super(Assets.brick, id);
	}
	
	public boolean isSolid()
	{
		return true;
	}
}
