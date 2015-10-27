package models.events;

import models.Event;
import models.Player;
import models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class SpaceGypsyEvent extends Event {
    private Player p;

    public SpaceGypsyEvent(int playerId, Round round, Player p) {
        super(playerId, round);
        this.p = new Player(playerId);
    }

    @Override
    public boolean badEvent() {
        return true;
    }

    @Override
    public String performEvent() {
        int change = 6 * getRound();
        p.setMoney(p.getMoney() - change);
        return "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $6" + change;
    }
}
