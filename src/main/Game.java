package main;

import main.display.Display;
import main.gfx.Assets;
// import main.gfx.ImageLoader;
// import main.gfx.SpriteSheet;
import main.input.KeyManager;
import main.states.GameState;
import main.states.MenuState;
import main.states.State;

import java.awt.Graphics;

import java.awt.image.BufferStrategy;
// import java.awt.image.BufferedImage;
// import java.awt.Color;


/* 'implements Runnable' allows code to run on a thread.
    It must have a run() function included with it within
    the class */
public class Game implements Runnable
{
	// Data
	private Display display;
	private int width, height;
	public String title;
	
	private Thread thread;
	private boolean running = false;
	/* A "BufferStrategy" object organizes memory/data on a 
	   canvas or window before it is actually displayed */
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	
	private KeyManager keyManager;
	
	// private BufferedImage test;
	// private SpriteSheet sheet;
	
	// Constructor
	public Game(String title, int width, int height)
	{
		/* When a new "Game" object instance is created, 
		   it will then create a new "Display" object instance 
		   for itself */
		display = new Display(title, width, height);
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
		/* When a new "Game" object instance is created, 
		   it will then create a new "Display" object instance 
		   for itself within this function */
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		// test = ImageLoader.loadImage("/textures/player.png");
		// sheet = new SpriteSheet(test);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}
	
	private void update()
	{
		keyManager.update();
		
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
		// Function will clear a certain portion of the screen
		g.clearRect(0, 0, width, height);
		
		// g.drawImage(Assets.player, 5, 5, null);
		if(State.getState() != null)
		{
			State.getState().render(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		init();
		/* Is the amount of times the 'update' and 'render'
		   functions should be called per second */
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
				delta--;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager()
	{
		return keyManager;
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
		/* Passing the "Game" class to the 
		   thread will run the class on the 
		   thread */
		thread = new Thread(this);
		// This function will call the "run" method
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

