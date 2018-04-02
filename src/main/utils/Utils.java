package main.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils 
{
	// Function will load in a file for us
	public static String loadFileAsString(String path)
	{
		// 'StringBuilder' object can be modified
		StringBuilder builder = new StringBuilder();
		
		try
		{
			/* BufferedReader will pass the 'path' parameter of type 
			   'FileReader' (reads a file two bytes at a time) when 
			   creating the new 'BufferedReader' object instance 'br' */
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			/* The return string value from readLine for this instance 
			   will be assigned to the string 'line'. The while loop
			   will continue as long as a string value is assigned to 
			   'line' and will terminate once 'line' is assigned a
			   null value */
			while((line = br.readLine()) != null)
			{
				/* The object instance will append the specified string
				   as it is currently in a string array structure */
				builder.append(line + "\n");
			}
			// Close connection 
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		// Will return a string representing the entirety of the file  
		return builder.toString();	
	}
	
	// Converts the string into an integer value which was read from the file
	public static int parseInt(String number)
	{
		try
		{
			return Integer.parseInt(number);
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
}
