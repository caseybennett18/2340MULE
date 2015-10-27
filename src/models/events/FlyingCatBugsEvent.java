package models.events;

import models.Event;
import models.Player;
import models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class FlyingCatBugsEvent extends Event {

    private Player p;

    public FlyingCatBugsEvent(int playerId, Round round, Player p) {
        super(playerId, round);
        this.p = new Player(playerId);
    }

    @Override
    public boolean badEvent() {
        return true;
    }

    @Override
    public String performEvent() {
        int change = 4 * getRound();
        p.setMoney(p.getMoney() - change);
        return "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $4" + change;
    }
}
