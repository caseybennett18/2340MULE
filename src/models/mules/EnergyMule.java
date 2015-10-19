package models.mules;

import models.Mule;
import models.Player;

/**
 * Created by Charlie on 10/4/2015.
 */
public class EnergyMule extends Mule{

    private Player p;


    public EnergyMule(int playerId, String buttonId, Player p) {
        super(playerId, buttonId);
        this.p = new Player(playerId);
        price = 150;
    }

    public void produce(Player p) {
        switch(buttonId) {
            case "plain":
                p.setEnergy(p.getEnergy() + 3);
                break;
            case "1mountain":
                p.setEnergy(p.getEnergy() + 1);
                break;
            case "2mountain":
                p.setEnergy(p.getEnergy() + 1);
                break;
            case "3mountain":
                p.setEnergy(p.getEnergy() + 1);
                break;
            case "river":
                p.setEnergy(p.getEnergy() + 2);
                break;
            default:
                p.setEnergy(p.getEnergy());
                break;
        }
    }

    @Override
    public String toString() {
        return "Energy Mule";
    }

}
