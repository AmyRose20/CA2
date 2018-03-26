package main.states;

import java.awt.Graphics;
import main.Game;
import main.entities.creatures.Player;
import main.gfx.Assets;

public class GameState extends State
{
	Player player;
	
	public GameState(Game game)
	{
		super(game);
		player = new Player(game, 100, 100);
	}
	
	public void update()
	{
		player.update();
	}

	public void render(Graphics g) 
	{
		// g.drawImage(Assets.player, 0, 0, null);
		player.render(g);
	}
}
