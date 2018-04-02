package main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* The "KeyListener" class is built in to receive
   keyboard inputs or outputs */
public class KeyManager implements KeyListener 
{
	// Data
	
	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean aUp, aDown, aLeft, aRight;
	
	// Constructor
	public KeyManager()
	{
		keys = new boolean[256];
	}
	
	// Methods
	
	public void update()
	{
		// Key value will be assigned to each variable
		/* Key will be false if it is not being pressed and
		   true if it is being pressed */
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		aUp = keys[KeyEvent.VK_UP];
		aDown = keys[KeyEvent.VK_DOWN];
		aLeft = keys[KeyEvent.VK_LEFT];
		aRight = keys[KeyEvent.VK_RIGHT];
	}
	
	public void keyPressed(KeyEvent e) 
	{
		// 'getKeyCode' will get the key that was pressed
		/* Returns true to the key if it is being pressed,
		   where it will then be assigned into the designated boolean
		   variable */
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) 
	{
		/* Returns false to the key if it is not being pressed,
		   where it will then be assigned into the designated boolean
		   variable */
		keys[e.getKeyCode()] = false;
	}
	
	/* Function must be included even if it is not used, as it
	   is mandatory in all child classes of 'KeyListener' */
	public void keyTyped(KeyEvent e)
	{
		
	}
}
