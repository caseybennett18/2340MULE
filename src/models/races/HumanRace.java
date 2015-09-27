package models.races;

import models.Race;

/**
 * represents Human Race
 *
 */
public class HumanRace extends Race {
	
	public HumanRace(int playerId) {
		super(playerId);
		money = 600;
	}
	
	@Override
	public void applyRaceModifier() {
		// TODO: Implement modifier
	}
	
	@Override
	public String toString() {
		return "Human";
	}

	@Override
	public int getMoney() {
		return money;
	}
}