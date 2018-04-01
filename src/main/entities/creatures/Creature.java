package main.entities.creatures;

import main.Game;
import main.Handler;
import main.entities.Entity;
import main.tiles.Tile;

public abstract class Creature extends Entity
{
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
		
	protected float speed;
	protected int health;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height)
	{
		/* super refers to the parent class
		   "Entity" where it will access the 
		   parameters passed to it's class
		   constructor*/
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move()
	{
		moveX();
		moveY();
	}
	
	public void moveX()
	{
		if(xMove > 0)//right
		{
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			// collision stuff // divide by tile to get tiles instead of pixels
			if(!collision_Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && 
			!collision_Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				x += xMove;
			}
			else
			{// convert into pixel coordinates
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}
		else if (xMove < 0)//left
		{
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			// collision stuff // divide by tile to get tiles instead of pixels
			if(!collision_Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && 
			!collision_Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				x += xMove;
			}
			else
			{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	public void moveY()
	{
		if(yMove < 0)
		{
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			// collision stuff // divide by tile to get tiles instead of pixels
			//upper left hand corner
			//upper right hand corner
			if(!collision_Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
			!collision_Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
			{
				y += yMove;
			}
			else
			{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}
		else if (yMove > 0)
		{
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collision_Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
			!collision_Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
			{
				y += yMove;
			}
			else
			{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}

	protected boolean collision_Tile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	public float getxMove() 
	{
		return xMove;
	}
	public void setxMove(float xMove) 
	{
		this.xMove = xMove;
	}

	public float getyMove() 
	{
		return yMove;
	}
	public void setyMove(float yMove)
	{
		this.yMove = yMove;
	}

	public float getSpeed() 
	{
		return speed;
	}
	public void setSpeed(float speed) 
	{
		this.speed = speed;
	}

	public int getHealth() 
	{
		return health;
	}
	public void setHealth(int health) 
	{
		this.health = health;
	}
}
