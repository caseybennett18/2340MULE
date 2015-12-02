package main.models.races;

import main.models.Race;

/**
 * Created by Charlie on 11/29/2015.
 */
public class PackerRace extends Race {

    public PackerRace(int playerId) {
        super(playerId);
        money = 1000;
    }

    @Override
    public void applyRaceModifier() {
        // TODO: Implement modifier
    }

    @Override
    public String toString() {
        return "Packer";
    }

    @Override
    public int getMoney() {
        return money;
    }
}
