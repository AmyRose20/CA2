package main.states;

import java.awt.Graphics;

import main.Game;
import main.entities.creatures.Player;
import main.tiles.Tile;
import main.worlds.World;

public class GameState extends State
{
	Player player;
	World world;
	
	public GameState(Game game)
	{
		super(game);
		player = new Player(game, 100, 100);
		world = new World("");
	}
	
	public void update()
	{
		world.update();
		player.update();
	}

	public void render(Graphics g) 
	{
		// g.drawImage(Assets.player, 0, 0, null);
		world.render(g);
		player.render(g);
		Tile.tiles[0].render(g, 0, 0);
	}
}
