package models.events;

import models.Event;
import models.Player;
import models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class DeadMooseRatEvent extends Event {

    private Player p;

    public DeadMooseRatEvent(int playerId, Round round, Player p) {
        super(playerId, round);
        this.p = new Player(playerId);
    }

    @Override
    public boolean badEvent() {
        return false;
    }

    @Override
    public String performEvent() {
        int change = 2 * getRound();
        p.setMoney(p.getMoney() + change);
        return "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $2" + change;
    }


}
