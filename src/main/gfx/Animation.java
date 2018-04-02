package main.gfx;

import java.awt.image.BufferedImage;

public class Animation
{
	// Data
	
	private int speed, index;
	// Array of frames to rotate through
	private BufferedImage[] frames;
	private long lastTime, timer;
	
	// Constructor
	
	public Animation(int speed, BufferedImage[] frames)
	{
		this.speed = speed;
		this.frames = frames;
		// Show first image
		index = 0;
		
		timer = 0;
		// Will get milliseconds that have passed since the start of the program
		lastTime = System.currentTimeMillis();
	}
	
	// Method
	
	/* Function is used to increment what index the 'getCurrentFrame'
	   method/getter will return */
	public void update()
	{
		/* timer will be equal to the time in milliseconds since
		   this function was last called */
		timer += System.currentTimeMillis() - lastTime;
		// Reset the system time to the current time that the function is now being called
		lastTime =  System.currentTimeMillis();
		
		if(timer > speed)
		{
			index++;
			timer = 0;
			if(index >= frames.length)
			{
				// Restart animation
				index = 0;
			}
		}
	}
	
	// Getter
	public BufferedImage getCurrentFrame()
	{
		// get current frame of animation
		return frames[index];
	}
}
