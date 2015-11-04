package main.models.events;

import main.MapScreenController;
import main.models.Event;
import main.models.Player;
import main.models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class GTAlumniEvent extends Event {

    private Player p;

    @Override
    public boolean badEvent() {
        return false;
    }

    @Override
    public String performEvent() {
        p = MapScreenController.getInstance().getCurrentPlayer();
        p.setFood(p.getFood() + 3);
        p.setEnergy(p.getEnergy() + 2);
        return "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS";
    }
}