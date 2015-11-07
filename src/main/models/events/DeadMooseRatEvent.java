package main.models.events;

import main.MapScreenController;
import main.models.Event;
import main.models.Player;
import main.models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class DeadMooseRatEvent extends Event {

    //public DeadMooseRatEvent() {
    //    p = MapScreenController.getInstance().getCurrentPlayer();
    //}

    @Override
    public boolean badEvent() {
        return false;
    }

    @Override
    public String performEvent() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        int change = 2 * getRound();
        p.setMoney(p.getMoney() + change);
        return "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + change;
    }


}
