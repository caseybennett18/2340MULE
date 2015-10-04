package models;

/**
 * Created by Charlie on 10/4/2015.
 */
public class Mule {


    private int playerId;

    protected int price;

    public Mule(int playerId) {
        this.playerId = playerId;
    }

    public String toString() {
        return "default Type";
    }

    public int getPrice() {
        return price;
    }


}
