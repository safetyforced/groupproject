package teamJAC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class fileIOHandler {

	static String[] customerInfo = new String[3];
	static String name = "";
	static String email = "";
	static int points = 0;

public static void saveData(ArrayList<CustomerHandler> customers) {

	Path customerPath = Paths.get("CustomerInformation.txt");
	File customerFile = customerPath.toFile();

	try {
		FileReader read = new FileReader(customerFile);
		BufferedReader in = new BufferedReader(read);
		
		FileWriter out = new FileWriter(customerFile);
			
			for (int i = 0; i < customers.size(); i++) {
		CustomerHandler customer = customers.get(i);
		customerInfo[0] = customer.getName();
		customerInfo[1] = customer.getEmail();
		customerInfo[2] = Integer.toString(customer.getPoints());
		
		out.append(customerInfo[0] + "," + customerInfo[1] + "," + customerInfo[2] + "\n");
			}
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


public static ArrayList<CustomerHandler> readData() {
	int points = 0;
	String[] lineItem = new String[3];
	ArrayList<CustomerHandler> customers = new ArrayList<CustomerHandler>();

	Path countriesPath = Paths.get("CustomerInformation.txt");
	File countriesFile = countriesPath.toFile();

	try {
		FileReader r = new FileReader(countriesFile);
		BufferedReader in = new BufferedReader(r);
		String line = in.readLine();

		while (line != null) {
			if (!line.equals(""))
				lineItem = line.split(",");
			points = Integer.parseInt(lineItem[2]);
			CustomerHandler customer = new CustomerHandler(lineItem[0], lineItem[1], points);
			customers.add(customer);
			line = in.readLine();
		}
		in.close();
	}

	catch (Exception e) {
		e.printStackTrace();
	}
	return customers;
}
}

