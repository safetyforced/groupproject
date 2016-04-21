package coffeeApp;
import java.util.*;
import teamJAC.CustomerHandler;
import teamJAC.fileIOHandler;

public class myApp {
	static Scanner Scan1 = new Scanner(System.in);
	static boolean userPick = true;
	static ArrayList<CustomerHandler> list;
public static void main(String[] args) {

    list=fileIOHandler.readData();	
	
	System.out.println("Welcome to JAC'S Java!");
	System.out.println();
	
	while (true)
	{
	System.out.print("Please enter your name:");
	String userName = Scan1.nextLine();
	
	String [ ] menu = {"", "add points", "redeem your points", "exit the app"};
	
	System.out.println();
	System.out.println("Menu:\n1) Add Points \n2) Redeem Points \n3) Exit App\nWhat would you like to do?");
	int userInput = getValidNumberInRange(1,menu.length-1);
	System.out.println();

	System.out.println("You chose to " + menu[userInput] + ".");
	
	System.out.println();

	if (userInput==3) 
	{ System.out.println("Have a great Day!");
		break;
	}

	}
	
	
}
	public static int readValidIntegerNoExp()
	{ while (!Scan1.hasNextInt()) {
			Scan1.nextLine();}

			int x = Scan1.nextInt();
			Scan1.nextLine();

			return x;
			
	}//makes users enter valid number in range
	public static int getValidNumberInRange(int min, int max) {

		int input = readValidIntegerNoExp();
		while ((input < min) || (input > max)) {
			System.out.println("Please put a number within range!");

			input = readValidIntegerNoExp();
		}
		return input;
}
	

public static int searchCustomer(String name){
	int x = 0;
	for (int i = 0; i < list.size(); i++) {
		if (list.get(i).getName().equalsIgnoreCase(name)){
			 x= list.get(i).getPoints();
		}
	}
	return x;
	
	
	
}		
}