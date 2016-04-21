package teamJAC;

public class CustomerHandler {

	private String name;
	private String email;
	private int points;

	public void incrementPoints(CustomerHandler customer) {
		points = customer.getPoints();
		points++;
		customer.setPoints(points);
		}
	
	public void getFreeDrink (CustomerHandler customer) {
		points = customer.getPoints();
		if (points > 10) {
		points -= 10;
		customer.setPoints(points);
		} else {
			int need = 10 - points;
			System.out.println("You don't have enough points, you need " + need + " more drinks to redeem.");
		}
		
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public CustomerHandler(String name, String email, int points) {
		super();
		this.name = name;
		this.email = email;
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public void setName(String firstName) {
		this.name = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerHandler addCustomer() {
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

		CustomerHandler customer = new CustomerHandler(name, email, 0);
		return customer;
	}
}
