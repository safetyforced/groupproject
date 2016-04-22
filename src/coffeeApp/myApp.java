package coffeeApp;
import java.util.*;
import teamJAC.CustomerHandler;
import teamJAC.fileIOHandler;

public class myApp {
	static Scanner Scan1 = new Scanner(System.in);
	static boolean userPick = true;
	static ArrayList<CustomerHandler> list;
	static int userPoints = 0;
	static int userPosition = 0;
		
	public static void main(String[] args) {

		list=fileIOHandler.readData();	
	
			System.out.println("Welcome to JAC'S Java!");
			System.out.println();
	
		
			System.out.print("Please enter your name:");
			String userName = Scan1.nextLine();
			userPosition = searchCustomer(userName);
			userPoints = list.get(userPosition).getPoints();
			System.out.println("Hello " + userName + "! You have " + userPoints + " points!");

				
				while (true)
				{
				System.out.println();
				System.out.println("Menu:\n1) Add Points \n2) Redeem Points \n3) Exit App\nWhat would you like to do?");
				int userInput = getValidNumberInRange(1,3);
				System.out.println();

							
						if (userInput == 1){
							userPoints++;
							list.get(userPosition).setPoints(userPoints);
							System.out.println("You now have " + userPoints + " points!");
						}
						else if (userInput == 2) {
							if (userPoints >= 10) {
							userPoints -= 10;
							list.get(userPosition).setPoints(userPoints);
							System.out.println("You now have " + userPoints + " points!");
							} 
						else {
								System.out.println("Nice try, wiseguy.");
								continue;
						}
						} 
						else if (userInput==3) 
						{ System.out.println("Have a great day!");
						fileIOHandler.saveData(list);
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
	}
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
			 x = i;
		}
	}
	return x;
}		
}