package models.races;

import models.Race;


public class Ugaite extends Race {
	
	public UgaiteRace(int playerId) {
		super(playerId);
	}
	
	@Override
	public void applyRaceModifier() {
		// TODO: Implement modifier
	}
	
	@Override
	public String toString() {
		return "Ugaite";
	}
}