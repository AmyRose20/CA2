package main.states;

import java.awt.Graphics;
import main.Handler;

public abstract class State 
{
	// Data
	protected Handler handler;
	
	/* This 'State' object instance will hold
	   what state we currently want to 'update'
	   and 'render'. 
	   Only a 'gameState' is available.
	   It is initialized as null because the game
	   is not running */
	private static State currentState = null;
	
	// Constructor
	public State(Handler handler)
	{
		this.handler = handler;
	}
	
	// Methods
	
	// abstract functions have no default implementation
	// All sub-classes will have it and they will all be different from each other
	public abstract void update();
	/* Must pass the 'Graphic' object instance 'g'
	   as a parameter so the state can essentially
	   draw onto the screen */
	public abstract void render(Graphics g);
	
	// Getter and Setter
	public static void setState(State state)
	{
		currentState = state;
	}
	
	public static State getState()
	{
		return currentState;
	}
}
