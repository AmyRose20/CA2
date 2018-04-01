package main.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	public static Tile[] tiles = new Tile[256];
	// 0 is the id
	public static Tile tile1 = new Tile1(0);
	public static Tile brickTile = new BrickTile(1);
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid()
	{
		return false;
	}
	
	public int getId()
	{
		return id;
	}
}
