package main.models.mules;

import main.models.Mule;
import main.models.Player;

/**
 * Created by Charlie on 10/4/2015.
 */
public class OreMule extends Mule {

    public OreMule(int playerId, String buttonId, Player p) {
        super(playerId, buttonId);
        Player p1 = new Player(playerId);
        price = 175;
    }

    public void produce(Player p) {
        switch(buttonId) {
            case "plain":
                p.setOre(p.getOre() + 1);
                break;
            case "1mountain":
                p.setOre(p.getOre() + 2);
                break;
            case "2mountain":
                p.setOre(p.getOre() + 3);
                break;
            case "3mountain":
                p.setOre(p.getOre() + 4);
                break;
            case "river":
                p.setOre(p.getOre());
                break;
            case "swamp":
                p.setOre(p.getOre() + 2);
                break;
            default:
                p.setOre(p.getOre());
                break;
        }
    }

    @Override
    public String toString() {
        return "Ore Mule";
    }
}
