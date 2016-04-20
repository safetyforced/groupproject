package teamJAC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileIOHandler {

public static void main(String[] args) {	
	
	Path productsPath = Paths.get("products.txt"); 
	File productsFile = productsPath.toFile();

try {
FileReader r = new FileReader(productsFile); 
BufferedReader in = new BufferedReader( r); 
String line = in.readLine();

	while (line !=null)
	{
		System.out.println(line);
		line = in.readLine(); }
	}
	catch (IOException e)
	{
		System.out.println(e);
	}


	
	
}	
}
