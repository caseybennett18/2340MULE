package models.races;

import models.Race;

/**
 * Represents Flapper Race
 *
 */
public class FlapperRace extends Race {
	
	public FlapperRace(int playerId) {
		super(playerId);
		money = 1600;
	}
	
	@Override
	public void applyRaceModifier() {
		// TODO: Implement modifier
	}
	
	@Override
	public String toString() {
		return "Flapper";
	}


	@Override
	public int getMoney() {
		return money;
	}
}