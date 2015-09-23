package models;

public class Race {
    
	private int playerId;
	
	public Race(int playerId) {
		this.playerId = playerId;
	}
	
	public void applyRaceModifier() {
	}

	public String toString() {
		return "DefaultRace";
	}
	
}
