package main.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import main.Handler;
import main.entities.creatures.Player;

/* This class is for managing our entities in
   an ArrayList, where an instance of the 
   entity can be easily duplicated or removed */
public class EntityManager 
{
	// Data
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	// Constructor 
	public EntityManager(Handler handler, Player player)
	{
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	// Methods
	public void update()
	{
		for(int i = 0; i < entities.size(); i++)
		{
			Entity e = entities.get(i);
			e.update();
			/* Entity instance from the ArrayList will be removed
			   if it has come into contact with the player when 
			   they have pressed the arrow keys, making it no longer
			   active (dead), removing it from the list. */
			if(!e.isActive())
			{
				entities.remove(e);
			}
		}
	}
	
	public void render(Graphics g)
	{
		/* For each loop states that for every
		   'Entity' object instance 'e' of the 
		   ArrayList entities, render it ie, draw
		   it to the screen */
		for(Entity e : entities)
		{
			e.render(g);
		}	
	}
	
	// Adding an entity to the ArrayList
	public void addEntity(Entity e)
	{
		entities.add(e);
	}

	// Getters and Setters
	public Handler getHandler() 
	{
		return handler;
	}
	public void setHandler(Handler handler) 
	{
		this.handler = handler;
	}

	public Player getPlayer() 
	{
		return player;
	}
	public void setPlayer(Player player) 
	{
		this.player = player;
	}

	public ArrayList<Entity> getEntities() 
	{
		return entities;
	}
	public void setEntities(ArrayList<Entity> entities) 
	{
		this.entities = entities;
	}
}
