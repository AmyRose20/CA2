package main.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import main.Handler;
import main.entities.Entity;
import main.gfx.Animation;
import main.gfx.Assets;

// This class is a child class to the parent class 'Creature' of the super class 'Entity'.
/* This means it will contain the functions and variables in these parent classes as
   well as individual characteristics */
public class Player extends Creature
{
	// Data
	
	// It is an animation and not an image because the imitation of movement is required
	private Animation animation;
	
	// Constructor
	
	public Player(Handler handler, float x, float y) 
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		bounds.x = 14;
		bounds.y = 18;
		bounds.width = 34;
		bounds.height = 34;
		
		animation = new Animation(70, Assets.player);
	}

	
	// Methods
	
	public void update() 
	{
		animation.update();
		getInput();
		move();
		checkContact();
	}
	
	/* This function will check if the player
	  has made contact/collision with the two
	  currently available static entities*/
	private void checkContact()
	{
		// cr = collision rectangle 
		// gc = get rectangle
		Rectangle gc = getCollisionBounds(0, 0);
		Rectangle cr = new Rectangle();
		// ADJUST
		int crSize = 20;
		cr.width = crSize;
		cr.height = crSize;
		
		if(handler.getKeyManager().aUp)
		{	// Get center x-coordinate
			cr.x = gc.x + gc.width / 2 - crSize / 2;
			cr.y = gc.y - crSize;
		}
		else if(handler.getKeyManager().aDown)
		{
			cr.x = gc.x + gc.width / 2 - crSize / 2;
			// Need to know the height of the rectangle
			cr.y = gc.y + gc.height;
		}
		else if(handler.getKeyManager().aLeft)
		{
			cr.x = gc.x - crSize;
			// center y-coordinate
			cr.y = gc.y + gc.height / 2 - crSize / 2;
		}
		else if(handler.getKeyManager().aRight)
		{
			cr.x = gc.x + gc.width;
			cr.y = gc.y + gc.height / 2 - crSize / 2;
		}
		else
		{
			// Return if player is not pressing any of the arrow keys
			return;
		}
		// Getting the ArrayList in our entity manager class
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this))
			{
				continue;
			}
			if(e.getCollisionBounds(0, 0).intersects(cr))
			{
				e.contact(10);
				// Return because contact with one entity at a time is made
				return;
			}
		}
	}
	
	/* Function is used for player movement. Will carry out 
	   statements below the if statements if W, S, A or D
	   are being pressed. This is checked by checking in the
	   'KeyManager' class for certain key inputs by the user */
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
		// The comments below were purely to see the collision/boundary Rectangle surrounding the player
		// g.setColor(Color.red);
		// g.fillRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
	}
}
