package main.models.events;

import main.models.Event;
import main.models.Player;
import main.MapScreenController;

/**
 * Created by Charlie on 10/26/2015.
 */
public class WanderingTechStudentEvent extends Event {

    //public WanderingTechStudentEvent() {
    //    p = MapScreenController.getInstance().getCurrentPlayer();
    //}

    @Override
    public boolean badEvent() {
        return false;
    }

    @Override
    public String performEvent() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        p.setOre(p.getOre() + 2);
        return "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.";
    }
}
