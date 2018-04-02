package main.entities.creatures;

import main.Handler;
import main.entities.Entity;
import main.tiles.Tile;

// This is a child class to the parent/super class 'Entity'
public abstract class Creature extends Entity
{
	// Data
	
	public static float DEFAULT_SPEED = 3.0f;
	public static int DEFAULT_CREATURE_WIDTH = 64;
	public static int DEFAULT_CREATURE_HEIGHT = 64;
		
	protected float speed;
	protected float xMove, yMove;
	
	// Constructor
	
	public Creature(Handler handler, float x, float y, int width, int height)
	{
		/* super refers to the parent/super class
		   'Entity', where it will access the 
		   parameters passed to it's class
		   constructor from the constructor in
		   'Entity' as they share the same values
		   for a particular instance */
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	// Methods
	
	/* This function will check the function 'checkEntityCollisions'
	 * in 'Entity' which will return a boolean value on whether or not
	   the player has made contact with another entity. If there is
	   no collisions, then the entity will continue to move. This
	   is check when trying to move along the x-axis and the
	   y-axis in the two if statements below */
	public void move()
	{
		if(!checkEntityCollisions(xMove, 0f))
		{
			moveX();
		}
		if(!checkEntityCollisions(0f, yMove))
		{
			moveY();
		}
	}
	
	public void moveX()
	{
		// If the x coordinates are > 0, the player is moving to the RIGHT
		if(xMove > 0)
		{
			/* tx is where the player is moving + the edge of the bounding
			   rectangle around the player + bounds.width to check the upper 
			   and lower right corners / Tile.TILEWIDTH to to get it in terms
			   of tiles for now and not pixels. This will get the X-COORDINATE
			   of the tile or entity the player is trying to move into */
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			/* Divide by tile to get tiles instead of pixels. This can also be used
			   for the entities, as they have the same default width and height as the tiles. */
			/* If statement says if there is no collision with tx and the tile the player is trying to 
			   move into. This is checked by the  UPPER RIGHT corner of the bounding Rectangle of the player). 
			   It must be divided in Tile.TILEHEIHGHT to get it in terms of tiles and not pixels */
			if(!collision_Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && 
			/* This will check if the LOWER RIGHT corner is making contact with the entity
			   or tile. This is why bound.height is used to get the position of the LOWER RIGHT
			   corner */
			!collision_Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				// Player position will move
				x += xMove;
			}
			else
			{	// Convert into pixel coordinates
				/* This will create the effect that the player
				   has hit the side of the entity or tile. Player
				   position will remain fixed */
				/* - bounds.width because it is right hand side and - 1
				 * so the entity is not on top of the tile */
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}
		// If the x coordinates are < 0, the player is moving to the LEFT
		else if (xMove < 0)
		{	/* This works similarly as the above if statement. This time, a collision
		 	   between the UPPER LEFT and LOWER LEFT corners of the players bounding
		 	   Rectangle are being tested for collisions. */
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
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
		// Moving up
		if(yMove < 0)
		{
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			// Checking TOP LEFT corner and TOP RIGHT corner
			if(!collision_Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
			// bounds.width to get position of TOP RIGHT corner
			!collision_Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
			{
				y += yMove;
			}
			else
			{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}
		// Moving down
		else if (yMove > 0)
		{
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			// Checking the BOTTOM LEFT corner and BOTTOM RIGHT corner
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

	/* 'GrassTile' is not solid and 'BrickTile' is.
	   Therefore, when each tile instance is returned,
	   if isSolid, then there will be a collision with the
	   player and the tile. If !isSolid, the player will
	   move freely over the Tile. */
	protected boolean collision_Tile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	// Getters and Setters
	
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
