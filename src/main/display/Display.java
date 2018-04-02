package main.display;

import javax.swing.JFrame;
import java.awt.*;

public class Display 
{
	// Data
	
	/* "JFrame" object instance will be used to display
	   a window. The object instance is private because 
	   no other class should need to access it */
	private JFrame frame;
	/* "Canvas" object allows us to draw graphics
	   within the window. The "Canvas" object will
	   hold the graphics and will be displayed 
	   using the "JFrame" */
	private Canvas canvas;
	
	// JFrame will need a title, width and height
	// These will be kept in the three variables below
	private String title;
	private int width, height;
	
	// Constructor
	
	// Variables will be initialized in this constructor
	// Variables will now hold values of the parameters passed
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		// Call function
		createDisplay();
	}
	
	// Method
	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		/* This function will make sure that the window
		   closes down properly */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* This will ensure that the window stays
		the width and height it is given by passing in
		the boolean value false as a parameter. This
		will indicate that the window cannot be
		resized */
		frame.setResizable(false);
		/* This will ensure that the window appears in
		   the middle of the screen/monitor */
		frame.setLocationRelativeTo(null);
		/* On default, JFrames are not visible so 
		   this function must be included to make it
		   visible */
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		/* Functions will make sure that the canvas will 
		   stay at the width and height we give it 
		 */
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		canvas.setFocusable(false);
		
		// Add our "Canvas" object instance to the "JFrame" object instance
		frame.add(canvas);
		// Will resize window so that we can see the canvas fully
		frame.pack();
	}
	
	// Getters
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
}
