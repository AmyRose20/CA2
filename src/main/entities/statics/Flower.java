package main.entities.statics;

import java.awt.Graphics;
import main.Handler;
import main.gfx.Assets;
import main.tiles.Tile;

// This is a child class to the parent class 'StaticEntity'
public class Flower extends StaticEntity
{
	// Constructor
	public Flower(Handler handler, float x, float y) 
		{
			super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
			
			/* The bounds values come from the 'Rectangle' object within
			   the 'Entity' super class and are assigned here. This 
			   'Rectangle' object acts as a collision/contact detection 
			   for the current class/object */
			bounds.x = 0;
			bounds.y = 0;
			bounds.width = 90;
			bounds.height = 40;	
		}

		// Methods
	
		/* Although update is not used, it is a requirement for 
		   every entity to have this function */
		public void update() 
		{
			
		}

		public void render(Graphics g) 
		{
			g.drawImage(Assets.flower, (int) x, (int) y, 90, 40, null);
			// g.setColor(Color.red);
			// g.fillRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
		}
}

