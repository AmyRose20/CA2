package main;

import main.input.KeyManager;
import main.worlds.World;

/* This class makes passing variables to anything
   more efficient and (NB) useful in programming 
   for games. 
   This 'handler' object will also make it easier to pass the
   'game' object and 'world' object in one class rather than two */
public class Handler 
{
	// Data
	private Game game;
	private World world;
	
	// Constructor
	public Handler(Game game)
	{
		this.game = game;
	}
	
	// Getters and setters
	/* Setters are similar to getters, however, they
	   will assign the parameter passed to a data type
	   or class of the same name within this class */
	/* Because we have passed the 'game' object,
	   we can access various getters within that class
	   such as the three below and they do not have to 
	   be defined in this 'handler' class */
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	
	public int getWidth()
	{
		return game.getWidth();
	}
	public int getHeight()
	{
		return game.getHeight();
	}
	
	public Game getGame() 
	{
		return game;
	}
	public void setGame(Game game) 
	{
		this.game = game;
	}
	
	public World getWorld() 
	{
		return world;
	}
	public void setWorld(World world) 
	{
		this.world = world;
	}
}
