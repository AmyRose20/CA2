package main;
/* Launcher class' function will simply
be used to start up the game
*/
public class Launcher 
{
	// main function
	public static void main(String[] args)
	{
		/* Creating a new 'Game' object instance called 'game'
		   and passing a string for it's title and two integer
		   values as the dimensions of the window */
		Game game = new Game("CA", 600, 600);
		/* Will call the 'start' function from the 'Game'
		   class for this particular instance */
		game.start();
	}
}