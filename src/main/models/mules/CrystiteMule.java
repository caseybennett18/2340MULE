package main.models.mules;

import main.models.Mule;
import main.models.Player;

/**
 * Created by caseybennett on 12/2/15.
 */
public class CrystiteMule extends Mule {
    public CrystiteMule(int playerId, String buttonId, Player p) {
        super(playerId, buttonId);
        Player p1 = new Player(playerId);
        price = 100;
    }

    public void produce(Player p) {
        switch(buttonId) {
            case "plain":
                p.setCrystite(p.getCrystite() + 3);
                break;
            case "1mountain":
                p.setCrystite(p.getCrystite() + 1);
                break;
            case "2mountain":
                p.setCrystite(p.getCrystite() + 1);
                break;
            case "3mountain":
                p.setCrystite(p.getCrystite() + 1);
                break;
            case "river":
                p.setCrystite(p.getCrystite() + 2);
                break;
            case "swamp":
                p.setCrystite(p.getCrystite() + 2);
                break;
            default:
                p.setCrystite(p.getCrystite());
                break;
        }
    }

    @Override
    public String toString() {
        return "Crystite Mule";
    }


}
