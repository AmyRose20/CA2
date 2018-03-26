package main.entities;

import java.awt.Graphics;

public abstract class Entity 
{
	/* protected is like a private variable, however
	   classes that extend this class has access to
	   it */
	protected float x, y;
	protected int width, height;
	
	public abstract void update();
	public abstract void render(Graphics g);
	
	public Entity(float x, float y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public float getX() 
	{
		return x;
	}
	public void setX(float x) 
	{
		this.x = x;
	}
	
	public float getY() 
	{
		return y;
	}
	public void setY(float y) 
	{
		this.y = y;
	}
	
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width) 
	{
		this.width = width;
	}
	
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height) 
	{
		this.height = height;
	}
}
