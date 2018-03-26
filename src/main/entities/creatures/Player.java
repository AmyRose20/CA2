package main.entities.creatures;

import java.awt.Graphics;

import main.Game;
import main.gfx.Assets;

public class Player extends Creature
{
	private Game game;

	public Player(Game game, float x, float y) 
	{
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	public void update() 
	{
		getInput();
		move();
	}
	
	public void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up)
		{
			yMove = -speed;
		}
		if(game.getKeyManager().down)
		{
			yMove = speed;
		}
		if(game.getKeyManager().left)
		{
			xMove = -speed;
		}
		if(game.getKeyManager().right)
		{
			xMove = speed;
		}
	}

	public void render(Graphics g) 
	{
		/* Must cascade x and y because 'drawImage' does
		   not pass floats as parameters */
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}

}
