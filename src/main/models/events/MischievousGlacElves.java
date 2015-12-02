package main.models.events;

import main.controllers.MapScreenController;
import main.models.Event;
import main.models.Player;

/**
 * Created by Charlie on 11/29/2015.
 */
public class MischievousGlacElves extends Event {

    @Override
    public boolean badEvent () {
        return true;
    }

    @Override
    public String performEvent() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        int food = p.getFood();
        p.setFood(food / 2);

        return "MISCHIEVOUS GLAC-ELVES BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.";
    }
}
