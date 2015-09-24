package models.races;

import models.Race;

/**
 * Created by Admin on 9/23/15.
 */
public class UgaiteRace extends Race{


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
