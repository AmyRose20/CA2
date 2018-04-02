package main.states;
import java.awt.Graphics;

import main.Handler;
import main.worlds.World;

public class GameState extends State
{
	World world;

	public GameState(Handler handler)
	{
		super(handler);
		/* This new 'World' object instance will pass in a text file.
		   This text file will be read in such a way where the first to 
		   numbers will be the dimension of the world and the next two numbers will be the
		   starting position of the world. The dimension of the world is literally then
		   typed out along with what 'Tile' object type to be used, which is specified by it's
		   id. In this case, the 'BrickTile' has an id of 1 and the 'GrassTile' has an id 
		   of 0. These tile will be rendered in the positions specified using a witdh and height
		   of 64. The gap between each number is also read 
		   The text file world.txt:
		   10 10
		   0 0
		   1 1 1 1 1 1 1 1 1 1
		   1 0 0 0 0 1 0 0 0 1
		   1 0 0 0 0 1 0 0 0 1
		   1 0 0 0 0 0 0 0 0 1
		   1 0 0 0 0 0 0 0 0 1
		   1 0 0 0 0 0 0 0 0 1
	       1 0 0 0 0 0 0 0 0 1
		   1 0 0 0 0 0 0 0 0 1
		   1 0 0 0 0 0 0 0 0 1
		   1 1 1 1 1 1 1 1 1 1 */
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		
	}
	
	public void update()
	{
		world.update();
	}

	public void render(Graphics g) 
	{
		world.render(g);
	}
}
