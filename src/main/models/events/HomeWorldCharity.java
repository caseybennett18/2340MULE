package main.models.events;

import main.MapScreenController;
import main.models.Event;
import main.models.Player;

/**
 * Created by Charlie on 11/29/2015.
 */
public class HomeWorldCharity extends Event {

    @Override
    public boolean badEvent() {
        return false;
    }

    @Override
    public String performEvent() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        int money = p.getMoney();
        p.setMoney(money + 200);

        return "A CHARITY FROM YOUR HOME-WORLD TOOK PITY ON YOU AND SENT $200";

    }
}
