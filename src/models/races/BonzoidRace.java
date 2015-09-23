package models.races;

import models.Race;


public class BonzoidRace extends Race {
	
	public BonzoidRace(int playerId) {
		super(playerId);
	}
	
	@Override
	public void applyRaceModifier() {
		// TODO: Implement modifier
	}
	
	@Override
	public String toString() {
		return "Bonzoid";
	}
}