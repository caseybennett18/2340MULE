package models.mules;

import models.Mule;
import models.Player;

/**
 * Created by Charlie on 10/4/2015.
 */
public class OreMule extends Mule {

    private Player p;

    public OreMule(int playerId, Player p) {
        super(playerId);
        this.p = new Player(playerId);
        price = 175;
    }

    public void produce() {
        p.setOre(p.getOre() + 1);
    }

    @Override
    public String toString() {
        return "Ore Mule";
    }
}
