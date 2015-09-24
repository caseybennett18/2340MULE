package models.races;

import models.Race;

/**
 * Represents Buzzite Race
 *
 */
public class BuzziteRace extends Race {
	
	public BuzziteRace(int playerId) {
		super(playerId);
	}
	
	@Override
	public void applyRaceModifier() {
		// TODO: Implement modifier
	}
	
	@Override
	public String toString() {
		return "Buzzite";
	}
}