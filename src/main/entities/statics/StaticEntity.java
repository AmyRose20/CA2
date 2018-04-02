package main.entities.statics;

import main.Handler;
import main.entities.Entity;

public abstract class StaticEntity extends Entity
{
	// Constructor
	
	public StaticEntity(Handler handler, float x, float y, int width, int height)
	{
		// Retrieves these values from the parent class 'Entity'
		super(handler, x, y, width, height);
	}
}
