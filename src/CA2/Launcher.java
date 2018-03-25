package CA2;

/* Launcher class' function will simply
be to start up the game
*/
public class Launcher 
{
	public static void main(String[] args)
	{
		Game game = new Game("CA", 600, 600);
		game.start();
	}
}
