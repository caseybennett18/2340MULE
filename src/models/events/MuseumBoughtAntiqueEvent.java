package models.events;

import models.Event;
import models.Player;
import models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class MuseumBoughtAntiqueEvent extends Event {

    private Player p;

    public MuseumBoughtAntiqueEvent(int playerId, Round round, Player p) {
        super(playerId, round);
        this.p = new Player(playerId);
    }

    @Override
    public boolean badEvent() {
        return false;
    }

    @Override
    public String performEvent() {
        int change = 8 * getRound();
        p.setMoney(p.getMoney() + change);
        return "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $ 8" + change;
    }
}
