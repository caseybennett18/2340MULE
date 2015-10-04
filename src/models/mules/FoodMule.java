package models.mules;

import models.Mule;
import models.Player;

/**
 * Created by Charlie on 10/4/2015.
 */
public class FoodMule extends Mule {

    private Player p;

    public FoodMule(int playerId, Player p) {
        super(playerId);
        this.p = new Player(playerId);
        price = 125;
    }

    public void produce() {
        p.setFood(p.getFood() + 1);
    }

    @Override
    public String toString() {
        return "Food Mule";
    }
}
