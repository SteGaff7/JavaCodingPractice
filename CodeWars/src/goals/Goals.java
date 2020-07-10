package goals;

public class Goals {
	public static int laLigaGoals = 43;
	public static int championsLeagueGoals = 10;
	public static int copaDelReyGoals = 5;
	  
	public static int totalGoals = sumGoals();
	
	private static int sumGoals() {
		return laLigaGoals + championsLeagueGoals + copaDelReyGoals;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
