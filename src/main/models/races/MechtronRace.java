package main.models.races;

/**
 * Created by Charlie on 11/29/2015.
 */

import main.models.Race;

/**
 * Represents Mechtron Race
 *
 */
public class MechtronRace extends Race {

    public MechtronRace(int playerId) {
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