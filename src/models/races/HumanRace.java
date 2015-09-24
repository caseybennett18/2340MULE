package models.races;

import models.Race;

/**
 * represents Human Race
 *
 */
public class HumanRace extends Race {
	
	public HumanRace(int playerId) {
		super(playerId);
	}
	
	@Override
	public void applyRaceModifier() {
		// TODO: Implement modifier
	}
	
	@Override
	public String toString() {
		return "Human";
	}
}