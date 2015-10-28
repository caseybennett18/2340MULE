package main.models.races;

import main.models.Race;

/**
 * Represents Buzzite Race
 *
 */
public class BuzziteRace extends Race {
	
	public BuzziteRace(int playerId) {
		super(playerId);
		money = 1000;
	}
	
	@Override
	public void applyRaceModifier() {
		// TODO: Implement modifier
	}
	
	@Override
	public String toString() {
		return "Buzzite";
	}

	@Override
	public int getMoney() {
		return money;
	}
}