package main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* The "KeyListener" class is built in to receive
   keyboard inputs or outputs */
public class KeyManager implements KeyListener 
{
	private boolean[] keys;
	public boolean up, down, left, right;
	
	public KeyManager()
	{
		keys = new boolean[256];
	}
	
	public void update()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}
	public void keyPressed(KeyEvent e) 
	{
		// 'getKeyCode' will get the key that was pressed
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) 
	{

	}
}
