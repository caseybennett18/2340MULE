package main.models.events;

import main.MapScreenController;
import main.models.Event;
import main.models.Player;

/**
 * Created by Charlie on 11/29/2015.
 */
public class MuleCleaningCost extends Event {

    @Override
    public boolean badEvent() {
        return true;
    }

    @Override
    public String performEvent() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        int mules = p.getOwnedMules().size();
        int money = p.getMoney();
        int cost = mules * 50;
        p.setMoney(money - cost);
        return "THE SOLAR COLLECTORS ON YOUR ENERGY MULES ARE DIRTY. CLEANING COST YOU $50 EACH.";
    }


}
