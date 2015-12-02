package main.models.events;

import main.controllers.MapScreenController;
import main.models.Event;
import main.models.Player;

/**
 * Created by Charlie on 10/26/2015.
 */
public class SpaceGypsyEvent extends Event {

    @Override
    public boolean badEvent() {
        return true;
    }

    @Override
    public String performEvent() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        int change = 6 * getRound();

        //makes sure a players $ cannot go below 0
        if (change > p.getMoney()) {
            change = p.getMoney();
            p.setMoney(0);
        } else {
            p.setMoney(p.getMoney() - change);
        }

        return "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $" + change;
    }
}
