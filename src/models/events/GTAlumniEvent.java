package models.events;

import models.Event;
import models.Player;
import models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class GTAlumniEvent extends Event {

    private Player p;

    public GTAlumniEvent(int playerId, Round round, Player p) {
        super(playerId, round);
        this.p = new Player(playerId);
    }

    @Override
    public boolean badEvent() {
        return false;
    }

    @Override
    public String performEvent() {
        p.setFood(p.getFood() + 3);
        p.setEnergy(p.getEnergy() + 2);
        return "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS";
    }
}
