package models.events;

import models.Event;
import models.Player;
import models.Round;

/**
 * Created by Charlie on 10/26/2015.
 */
public class WanderingTechStudentEvent extends Event {

    private Player p;

    public WanderingTechStudentEvent(int playerId, Round round, Player p) {
        super(playerId, round);
        this.p = new Player(playerId);
    }

    @Override
    public boolean badEvent() {
        return false;
    }

    @Override
    public String performEvent() {
        p.setOre(p.getOre() + 2);
        return "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.";
    }
}
