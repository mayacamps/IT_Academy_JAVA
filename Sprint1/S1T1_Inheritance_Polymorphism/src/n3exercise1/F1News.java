package n3exercise1;

public class F1News extends News {

	// VARIABLES
	private String team;
	
	// CONSTRUCTOR
	public F1News(String headline, String team) {
		super(headline);
		this.team = team;
	}
	
	// GETTERS N SETTERS
	public String getTeam() {
		return this.team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	// METHODS
	@Override
	public int calcNewsPrice() {
		int price = 100;
		price += (this.team.equalsIgnoreCase("Ferrari") || this.team.equalsIgnoreCase("Mercedes")) ? 50 : 0;
	
		return price;
	}

	@Override
	public int calcNewsPoints() {
		int points = 4;
		points += (this.team.equalsIgnoreCase("Ferrari") || this.team.equalsIgnoreCase("Mercedes")) ? 3 : 0;
	
		return points;
	}

	@Override
	public String toString() {
		return "Sport: Formula 1"
				+ "\nHeadline: " + this.getHeadline()
				+ "\nTeam: " + this.getTeam()
//				+ "\nPrice: " + this.getPrice() + " eur"
//				+ "\nPoints: " + this.getPoints()	
				+ "\n";
	}

}
