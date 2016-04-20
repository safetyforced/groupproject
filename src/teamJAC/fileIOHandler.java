package teamJAC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileIOHandler {

public static void addCustomer() {	
	String name = "";
	String email = "";
	
	Path companyPath = Paths.get("CustomerInformation.txt");
	File customerFile = companyPath.toFile();
	System.out.print("Enter the person's name: ");

	try {
		name = validator.getValidString("[a-z A-Z]+", 300);
	} catch (Exception e) {
		// catches all exceptions and prints

		e.printStackTrace();
	}
	
	System.out.print("Enter the person's e-mail address: ");
	
	try {
		email = validator.getValidString("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\\b", 300);
	} catch (Exception e) {
		// catches all exceptions and prints

		e.printStackTrace();
	}

	try {
		FileReader read = new FileReader(customerFile);
		BufferedReader in = new BufferedReader(read);
		String line = in.readLine();
		FileWriter out = new FileWriter(customerFile);
		while (line != null) {
			if (!line.equals("")) {
				out.append(line + "\n");
				line = in.readLine();
			} else {
				break;
			}
		}
		out.append(name + "," + email + "," + 0);
		out.close();
		in.close();

	} catch (FileNotFoundException e) {
		// catches file not found exception and prints

		e.printStackTrace();
	} catch (IOException e) {
		// catches file not found exception and prints

		e.printStackTrace();
	}


	
	
}	
}
