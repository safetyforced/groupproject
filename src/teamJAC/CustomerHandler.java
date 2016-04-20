package teamJAC;

public class CustomerHandler {

	private String name;
	private String email;
	private int points;
	
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
	
	
}
