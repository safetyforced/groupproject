package teamJAC;
 //Alex

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Vendor {

	static String companyName;
	static String companyContact;
	
	public static String getCompanyName() {
		return companyName;
	}
	
	public static void setCompanyName(String companyName) {
		Vendor.companyName = companyName;
	}
	
	public static String getCompanyContact() {
		return companyContact;
	}
	
	public static void setCompanyContact(String companyContact) {
		Vendor.companyContact = companyContact;
	}
	
	public static void writeCompany () {
		Path companyPath = Paths.get("VendorInformation.txt");
		File companyFile = companyPath.toFile();
		System.out.print("Enter the company's name: ");

		try {
			setCompanyName(validator.getValidString("[a-z A-Z]+", 300));
		} catch (Exception e) {
			// catches all exceptions and prints

			e.printStackTrace();
		}
		
		System.out.print("Enter the company's e-mail address: ");
		
		try {
			setCompanyContact(validator.getValidString("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\\b", 300));
		} catch (Exception e) {
			// catches all exceptions and prints

			e.printStackTrace();
		}

		try {
			FileReader read = new FileReader(companyFile);
			BufferedReader in = new BufferedReader(read);
			String line = in.readLine();
			FileWriter out = new FileWriter(companyFile);
			while (line != null) {
				if (!line.equals("")) {
					out.append(line + "\n");
					line = in.readLine();
				} else {
					break;
				}
			}
			out.append(companyName + "," + companyContact);
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
	
	
	
	
	
	
	
	
	
	
	public static boolean approveCoupon (String code) {
		
		if (code.equals("Read object")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	
	
	
	
}
