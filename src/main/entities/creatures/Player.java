package main.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import main.Handler;
import main.gfx.Animation;
import main.gfx.Assets;

public class Player extends Creature
{
	
	private Animation animation;

	public Player(Handler handler, float x, float y) 
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		bounds.x = 14;
		bounds.y = 18;
		bounds.width = 34;
		bounds.height = 34;
		
		animation = new Animation(70, Assets.player);
	}

	public void update() 
	{
		animation.update();
		getInput();
		move();
		// game.getGameCamera().centerOnEntity(this);
	}
	
	public void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
		{
			yMove = -speed;
		}
		if(handler.getKeyManager().down)
		{
			yMove = speed;
		}
		if(handler.getKeyManager().left)
		{
			xMove = -speed;
		}
		if(handler.getKeyManager().right)
		{
			xMove = speed;
		}
	}

	public void render(Graphics g) 
	{
		/* Must cascade x and y because 'drawImage' does
		   not pass floats as parameters */
		g.drawImage(animation.getCurrentFrame(), (int) (x), (int) (y), width, height, null);
		
		// g.setColor(Color.red);
		// g.fillRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
	}

}
