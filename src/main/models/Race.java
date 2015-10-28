package main.models;


/**
 * Holds information about the race
 *
 */
public class Race {
    
    /**
	 * id of player who is the Race
	 */
	private int playerId;

	protected static int money;
	
	/**
	 * Creates a new race associated to a player through their playerId
	 * @param playerId
	 */
	public Race(int playerId) {
		this.playerId = playerId;
	}
	
	/**
	 * Applies race modifier bonus to that player
	 */
	public void applyRaceModifier() {
	}

	/**
	 * @return string "DefaultRace"
	 * Applies race modifier bonus to that player
	 */
	public String toString() {
		return "DefaultRace";
	}

	public int getMoney() {
		return money;
	}
	
}
