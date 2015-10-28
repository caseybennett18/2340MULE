package main.models.events;

import main.MapScreenController;
import main.models.Event;
import main.models.Player;
import main.models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class MuseumBoughtAntiqueEvent extends Event {

    private Player p;

    @Override
    public boolean badEvent() {
        return false;
    }

    @Override
    public String performEvent() {
        p = MapScreenController.getInstance().getCurrentPlayer();
        int change = 8 * getRound();
        p.setMoney(p.getMoney() + change);
        return "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + change;
    }
}
