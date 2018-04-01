package main.entities.statics;

import java.awt.Graphics;

import main.Handler;
import main.gfx.Assets;
import main.tiles.Tile;

public class Tree1 extends StaticEntity
{

	public Tree1(Handler handler, float x, float y) 
	{
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
	}

	public void update() 
	{
		
	}

	public void render(Graphics g) 
	{
		g.drawImage(Assets.flowers, (int) x, (int) y, 90, 40, null);
	}
}
