package main.worlds;

import java.awt.Graphics;

import main.Game;
import main.Handler;
import main.tiles.Tile;
import main.utils.Utils;

public class World 
{
	private Handler handler;
	private int width, height, spawnX, spawnY;
	private int[][] tiles;
	
	public World(Handler handler, String path)
	{
		this.handler = handler;
		loadWorld(path);
	}

	public void update()
	{
		
	}
	
	public void render(Graphics g)
	{
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				getTile(x, y).render(g, (int) ((int) x * (Tile.TILEWIDTH)), (int) (y  * Tile.TILEHEIGHT));
			}
		}
	}
	
	public Tile getTile(int x, int y)
	{
		if(x < 0 || y < 0|| x >= width || y >= height)
		{
			// return Tile.tile1;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
		{
			return Tile.tile1;
		}
		return t;
	}
	
	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
}
