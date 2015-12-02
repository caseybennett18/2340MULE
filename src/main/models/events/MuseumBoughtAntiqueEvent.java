package main.models.events;

import main.controllers.MapScreenController;
import main.models.Event;
import main.models.Player;

/**
 * Created by Charlie on 10/26/2015.
 */
public class MuseumBoughtAntiqueEvent extends Event {

    @Override
    public boolean badEvent() {
        return false;
    }

    @Override
    public String performEvent() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        int change = 8 * getRound();
        p.setMoney(p.getMoney() + change);
        return "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + change;
    }
}
