package main.models.events;

import main.controllers.MapScreenController;
import main.models.Event;
import main.models.Player;

/**
 * Created by Charlie on 10/26/2015.
 */
public class UGAStudentEvent extends Event {

    @Override
    public boolean badEvent() {
        return true;
    }

    @Override
    public String performEvent() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        p.setFood(p.getFood() / 2);

        return "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.";
    }
}
