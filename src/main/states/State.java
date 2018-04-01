package main.states;

import java.awt.Graphics;

import main.Game;
import main.Handler;

public abstract class State 
{
	protected Handler handler;
	
	/* This "State" object instance will hold
	   what state we currently want to 'update'
	   and 'render' */
	private static State currentState = null;
	
	public State(Handler handler)
	{
		this.handler = handler;
	}
	
	public static void setState(State state)
	{
		currentState = state;
	}
	
	public static State getState()
	{
		return currentState;
	}
	
	public abstract void update();
	/* Must pass the "Graphic" object instance 'g'
	   as a parameter so the state can essentially
	   draw onto the screen */
	public abstract void render(Graphics g);
}
