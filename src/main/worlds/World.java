package main.worlds;

import java.awt.Graphics;
import main.Handler;
import main.entities.EntityManager;
import main.entities.creatures.Player;
import main.entities.statics.Flower;
import main.entities.statics.Tree;
import main.tiles.Tile;
import main.utils.Utils;

public class World 
{
	// Data
	
	private Handler handler;
	private int width, height, spawnX, spawnY;
	private int[][] tiles;
	
	private EntityManager entityManager;
	
	// Constructor
	public World(Handler handler, String path)
	{
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 500, 500));
		
		/* Creating new entity instances for the world 
		  and adding it to the 'entities' ArrayList */
		entityManager.addEntity(new Tree(handler, 180, 100));
		entityManager.addEntity(new Tree(handler, 300, 500));
		entityManager.addEntity(new Tree(handler, 450, 300));
		entityManager.addEntity(new Flower(handler, 80, 400));
		entityManager.addEntity(new Flower(handler, 480, 180));
		// Will load the file world and display the tiles specified
		loadWorld(path);	
	}

	// Methods

	public void update()
	{
		entityManager.update();
	}
	
	public void render(Graphics g)
	{
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				/* Tile from position (x, y) will be retrieved and rendered and multiplied by their width and 
				height of 64 */
				getTile(x, y).render(g, (int) ((int) x * (Tile.TILEWIDTH)), (int) (y  * Tile.TILEHEIGHT));
			}
		}
		// Once the tiles have been rendered, then the entities will be rendered
		entityManager.render(g);
	}
	
	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		// This split function takes into consideration the blank spaces between each number
		String[] tokens = file.split("\\s+");
		// These variables will be assigned to the first four numbers in the file
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				// Must convert x, y coordinates into a one dimensional array
				// + 4 because the first four elements in the array are assigned to the variables above
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	// Getters
	public EntityManager getEntityManager() 
	{
		return entityManager;
	}
	
	public Tile getTile(int x, int y)
	{
		Tile t = Tile.tiles[tiles[x][y]];
		return t;
	}
}
