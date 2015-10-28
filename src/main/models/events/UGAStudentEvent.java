package main.models.events;

import main.MapScreenController;
import main.models.Event;
import main.models.Player;
import main.models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class UGAStudentEvent extends Event {

    private Player p;

    @Override
    public boolean badEvent() {
        return true;
    }

    @Override
    public String performEvent() {
        p = MapScreenController.getInstance().getCurrentPlayer();
        p.setFood(p.getFood() / 2);

        return "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.";
    }
}
