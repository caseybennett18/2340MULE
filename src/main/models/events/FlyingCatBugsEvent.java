package main.models.events;

import main.MapScreenController;
import main.models.Event;
import main.models.Player;
import main.models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class FlyingCatBugsEvent extends Event {

    private Player p;

    @Override
    public boolean badEvent() {
        return true;
    }

    @Override
    public String performEvent() {
        p = MapScreenController.getInstance().getCurrentPlayer();
        int change = 4 * getRound();

        //makes sure a players $ cannot go below 0
        if (change > p.getMoney()) {
            change = p.getMoney();
            p.setMoney(0);
        } else {
            p.setMoney(p.getMoney() - change);
        }
        return "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $" + change;
    }
}
