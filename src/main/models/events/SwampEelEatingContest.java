package main.models.events;

import main.controllers.MapScreenController;
import main.models.Event;
import main.models.Player;

/**
 * Created by Charlie on 11/29/2015.
 */
public class SwampEelEatingContest extends Event {

    @Override
    public boolean badEvent () {
        return false;
    }

    @Override
    public String performEvent() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        int money = p.getMoney();
        p.setMoney(money + 1000);

        return "YOU WON THE COLONY SWAMP EEL EATING CONTEST AND COLLECTED $1000. (YUCK!)";
    }
}
