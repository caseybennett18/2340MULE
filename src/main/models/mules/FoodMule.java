package main.models.mules;

import main.models.Mule;
import main.models.Player;

/**
 * Created by Charlie on 10/4/2015.
 */
public class FoodMule extends Mule {

    public FoodMule(int playerId, String buttonId, Player p) {
        super(playerId, buttonId);
        Player p1 = new Player(playerId);
        price = 125;
    }

    public void produce(Player p) {
        switch(buttonId) {
            case "plain":
                p.setFood(p.getFood() + 2);
                break;
            case "1mountain":
                p.setFood(p.getFood() + 1);
                break;
            case "2mountain":
                p.setFood(p.getFood() + 1);
                break;
            case "3mountain":
                p.setFood(p.getFood() + 1);
                break;
            case "river":
                p.setFood(p.getFood() + 4);
                break;
            default:
                p.setFood(p.getFood());
                break;
        }

    }

    @Override
    public String toString() {
        return "Food Mule";
    }
}
