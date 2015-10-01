package models;

/**
 * Created by clint on 9/30/15.
 */
public class Gamble {

    private int winnings;

    public Gamble() {
        this.winnings = 0;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(int bonusValue) {
        winnings = bonusValue;
    }

}
