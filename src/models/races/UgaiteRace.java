package models.races;

import models.Race;

/**
 * represents UgaiteRace
 */
public class UgaiteRace extends Race{


    public UgaiteRace(int playerId) {
        super(playerId);
        money = 1000;
    }

    @Override
    public void applyRaceModifier() {
        // TODO: Implement modifier
    }

    @Override
    public String toString() {
        return "Ugaite";
    }

    @Override
    public int getMoney() {
        return money;
    }
}
