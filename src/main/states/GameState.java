package main.states;
import java.awt.Graphics;

import main.Handler;
import main.entities.creatures.Player;
import main.entities.statics.Tree1;
import main.tiles.Tile;
import main.worlds.World;

public class GameState extends State
{
	Player player;
	World world;
	private Tree1 tree;
	
	public GameState(Handler handler)
	{
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);	
		tree = new Tree1(handler, 65, 300);
	}
	
	public void update()
	{
		world.update();
		player.update();
		tree.update();
	}

	public void render(Graphics g) 
	{
		// g.drawImage(Assets.player, 0, 0, null);
		world.render(g);
		tree.render(g);
		player.render(g);
		// Tile.tiles[0].render(g, 0, 0);
	}
}
