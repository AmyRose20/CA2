package CA2;

import CA2.display.Display;
import CA2.gfx.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Color;

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
	}
	
	private void update()
	{
		
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
		
		g.drawRect(0, 0, width, height);
	
		
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		init();
		while(running)
		{
			update();
			render();
		}
		
		stop();
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
