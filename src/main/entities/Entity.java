package main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import main.Handler;

/* This class is an abstract class which means it is a
   parent class to child classes. This parent classes
   functionalities will be present in all the child
   classes. The child classes will have their own
   individual functions or variables not present
   in this class. */
public abstract class Entity 
{
	// Data
	
	/* Variable is static because variable instances
	   must be accessed by other classes */
	public static int DEFAULT_HEALTH = 10;
	/* protected is like a private variable, however
	   classes that extend this class has access to
	   it */
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	
	protected int health;
	protected boolean active = true;
	
	protected Rectangle bounds;
	
	// Constructor
	
	// Function obtains the coordinates, width, height and other stats of the entity 
	public Entity(Handler handler, float x, float y, int width, int height)
	{
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		health = DEFAULT_HEALTH;
		bounds = new Rectangle(0 , 0, width, height);
	}
	
	// Methods
	public abstract void update();
	public abstract void render(Graphics g);
	
	/* Currently this function only applies to the 'Flower'
	   object and 'Player' object. An amount of ten will
	   be passed as a parameter and subtracted from health,
	   leaving a value of 0 */
	public void contact(int amt)
	{
		health -= amt;
		if(health <= 0)
		{
			/* health is then checked if it is <= 0,
			   and it shall be removed from the list if it is */
			active = false;
		}
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset)
	{
		/* This for loop will retrieve the entity list of all entities 
		 * and check for collisions, returning true id there is */
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			/* This first if statement simply means that the loop through
			   the entity list will skip the remaining code in the loop and
			   continue to the next entity of the list. It does this because
			   we do not want to test if an entity collides with itself */
			if(e.equals(this))
			{
				continue;
			}
			
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
			{
				return true;
			}
		}
		return false;
	}
	
	/* This function will return the collision boundaries of the entity, which will be a smaller area around
	   the entity (in the case of the player), rather than the entire entity itself */
	public Rectangle getCollisionBounds(float xOffset, float yOffset)
	{
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	// Getters and Setters 
	public float getX() 
	{
		return x;
	}
	public void setX(float x) 
	{
		this.x = x;
	}
	
	public float getY() 
	{
		return y;
	}
	public void setY(float y) 
	{
		this.y = y;
	}
	
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width) 
	{
		this.width = width;
	}
	
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height) 
	{
		this.height = height;
	}
	
	public int getHealth() 
	{
		return health;
	}
	public void setHealth(int health) 
	{
		this.health = health;
	}
	
	public boolean isActive() 
	{
		return active;
	}
	public void setActive(boolean active) 
	{
		this.active = active;
	}
}
