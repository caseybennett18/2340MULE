package models;


/**
 * Created by Charlie on 10/4/2015.
 */
public abstract class Mule {


    private int playerId;
    protected String buttonId;

    protected int price;

    public Mule(int playerId, String buttonId) {
        this.playerId = playerId;
        this.buttonId = buttonId;
    }

    public String toString() {
        return "default Type";
    }

    public int getPrice() {
        return price;
    }

    public void produce(Player p) {
    }

    public void setButtonId(String id) {
        buttonId = id;
    }

    public String getButtonId() {
        return buttonId;
    }

}
