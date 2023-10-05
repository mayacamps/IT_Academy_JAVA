package n3exercise1;

public class FballNews extends News{

	// ATRIBUTES
	private String comp, team, player;
	
	// CONSTRUCTOR	
	public FballNews(String headline, String competition, String team, String player) {
		super(headline);
		this.comp = competition;
		this.team = team;
		this.player = player;
	}

	// GETTERS N SETTERS
	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
	// GENERAL METHODS
	@Override
	public int calcNewsPrice() {
		int price = 300;
		
		price += (this.comp.equalsIgnoreCase("Lliga de Campions")) ? 100 : 0;
		
		price += (this.team.equalsIgnoreCase("Barça") || this.team.equalsIgnoreCase("Madrid")) ? 100 : 0;
		
		price += (this.player.equalsIgnoreCase("Ferran Torres") || this.player.equalsIgnoreCase("Benzema")) ? 50 : 0;

		return price;
	}

	@Override
	public int calcNewsPoints() {
		int points = 5;
		
		points += (this.comp.equalsIgnoreCase("Lliga de Campions")) ? 3 : 0;
		
		points += (this.comp.equalsIgnoreCase("Lliga")) ? 2 : 0;
		
		points += (this.team.equalsIgnoreCase("Barça") || this.team.equalsIgnoreCase("Madrid")) ? 1 : 0;
		
		points += (this.player.equalsIgnoreCase("Ferran Torres") || this.player.equalsIgnoreCase("Benzema")) ? 1 : 0;

		return points;
	}

	@Override
	public String toString() {
		return "Sport: Football"
				+ "\nHeadline: " + this.getHeadline()
				+ "\nCompetition: " + this.getComp()
				+ "\nTeam: " + this.getTeam()
				+ "\nPlayer: " + this.getPlayer()
//				+ "\nPrice: " + this.getPrice() + " eur"
//				+ "\nPoints: " + this.getPoints()	
				+ "\n";
	}

}
