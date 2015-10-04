package models.mules;

import models.Mule;
import models.Player;

/**
 * Created by Charlie on 10/4/2015.
 */
public class EnergyMule extends Mule{

    private Player p;

    public EnergyMule(int playerId, Player p) {
        super(playerId);
        this.p = new Player(playerId);
        price = 150;
    }

    public void produce() {
        p.setEnergy(p.getEnergy() + 1);
    }

    @Override
    public String toString() {
        return "Energy Mule";
    }
}
