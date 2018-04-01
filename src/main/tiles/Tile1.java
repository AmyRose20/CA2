package main.tiles;

import main.gfx.Assets;

public class Tile1 extends Tile
{
	public Tile1(int id) 
	{
		super(Assets.grass, id);
	}
	
	public boolean isSolid()
	{
		return false;
	}
}
