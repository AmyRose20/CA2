// This file is stored in the main package of the game
package main;

import main.display.Display;
import main.gfx.Assets;
import main.input.KeyManager;
import main.states.GameState;
import main.states.State;
// These are built in classes 
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/* 'implements Runnable' allows code to run on a thread.
    It must have a run() function included with it within
    the class */
public class Game implements Runnable
{
	// Data
	
	/* Here, variables are declared and object instances 
	   of various classed are created */
	
	/* 'Display' object will be used for displaying
	 	a window and canvas object to the screen */
	private Display display;
	private int width, height;
	public String title;
	
	// Game will run on a 'Thread' object instance
	private Thread thread;
	// Initially, the game is not running
	private boolean running = false;
	/* A 'BufferStrategy' object organizes memory/data on a 
	   canvas or window before it is actually displayed */
	private BufferStrategy bs;
	/* A 'Graphics' object is a super class for allowing
	   applications to draw onto components */
	private Graphics g;
	
	/* Originally was going to have a 'menuState', hence the parent
	   class 'State'. 'State' object. The 'State' class will render
	   and update the game. */
	private State gameState;
	
	/* 'keyManager' class is primarily used to read what keys the 
	    user has pressed. This class implements 'KeyListener' which
	    means functions of this class can be used. */
	private KeyManager keyManager;
	
	// Class is used for better organization of game
	private Handler handler;
	
	// Constructor
	public Game(String title, int width, int height)
	{
		/* When a new 'Game' object instance is created, 
		   it will then create a new "Display" object instance 
		   for itself */
		display = new Display(title, width, height);
		/* Variables that were passed as parameters are assigned to
		   variables already within this class, hence the 'this' */
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	// Methods
	
	/* This function is like the setup for the game
	   and is only called once */
	private void init()
	{
		/* 'display' object instance will use its function
		   'getFrame' to return a 'JFrame' object instance. This
		   'JFrame' object instance is used to display window along
		   	with having the functions of 'KeyListener' within the window
		   	and passing 'keyManager' as a parameter for a new 'KeyListener'
		    object */
		display.getFrame().addKeyListener(keyManager);
		// Apply the 'init' function within the 'Assets' class
		Assets.init();
		
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		// Set the current state of the application to the game 
		State.setState(gameState);
	}
	
	private void update()
	{
		keyManager.update();
		/* If there is no current state set for the application,
		   then the current state will be retrieved (which should be 
		   the 'gameState' instance of the 'GameState' object initialized in
		   init) and updated */
		if(State.getState() != null)
		{
			State.getState().update();
		}
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		/* "getDrawGraphics()" creates a graphic context 
		   for the drawing buffer
		 */
		g = bs.getDrawGraphics();
		// Function will clear the entirity of the screen
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null)
		{
			// Function will render the world of the game in 'GamState'
			State.getState().render(g);
		}
		// Show images to screen
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		init();
		/* Is the amount of times the 'update' and 'render'
		   functions will be called per second. fps
		   stands for frame per second */
		int fps = 60;
		/* This is the maximum amount of time we have in 
		   nanoseconds to execute 'update' and 'render' */
		double timePerUpdate = 1000000000 / fps;
		/* Variable will tell computer when and when 
		   not to call the 'update' and 'render'methods */
		double delta = 0;
		long now;
		/* This variable returns the amount of time in 
		   nanoseconds that the computer is running at */
		long lastTime = System.nanoTime();
		
		while(running)
		{
			/* Setting the 'now' variable to the current 
			   time of the computer in nanoseconds */
			now = System.nanoTime();
			/* (now - lastTime) will equal the amount of
			   time passed since this piece of code 
			   was run. Then we will divide that time by
			   the maximum amount of time that is allowed to
			   call the 'update' and 'render' functions */
			delta += (now - lastTime) / timePerUpdate;
			lastTime = now;
			
			if(delta >= 1)
			{
				update();
				render();
				/* 'delta' value will decrease so 'update' 
				and 'render' can be called again */
				delta--;
			}
		}
		// Will call method to stop the thread as it is no longer running
		stop();
	}
	
	// Getters - returns values of private methods
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public synchronized void start()
	{
		/* In case the game is already running, we do not
		   want to execute any of the code in this function so
		   we will return */
		if(running)
		{
			return;
		}
		running = true;
		/* Passing the 'Game' object to the 
		   thread will run the class on the 
		   thread */
		thread = new Thread(this);
		/* This function will call the 'run' method,
		   the function for running the program/application */
		thread.start();
	}
	
	// Next two methods will start and stop threads
	public synchronized void stop()
	{
		/* In case the game is has already stopped, we do not
		   want to execute any of the code in this function so
		   we will return */
		if(!running)
		{
			return;
		}
		try
		{
			// Close the thread
			thread.join();
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}

