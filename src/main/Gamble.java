package main;

import java.util.Random;

/**
 * Created by clint on 9/30/15.
 * The Gamble class calculates money bonus based off round phase and time left.
 */
public class Gamble {

    private int winnings;
    private Random rand;

    public Gamble() {
        this.winnings = 0;
        rand = new Random();
    }

    /**
     * Getter for Winning
     * Param: none
     * Return Type: int
     */
    public int getWinnings() {
        return winnings;
    }

    /**
     * Setter for Winnings: winnings = bonusValue.
     * Param: bonusValue
     * Return Type: void
     */
    public void setWinnings(int bonusValue) {
        winnings = bonusValue;
    }

    /**
     * CalculateBonus method calculates bonus with round phase + time left in your round.
     * Param: bonusValue
     * Return Type: void
     */
    public int calculateBonus(int timeLeft, int roundPhase) {
        int moneyBonus;
        int timeBonus;
        int roundBonus;

        if (roundPhase >= 0 && roundPhase <= 2) {
            roundBonus = 50;
        } else if (roundPhase >= 3 && roundPhase <= 6) {
            roundBonus = 100;
        } else if (roundPhase >= 7 && roundPhase <= 10) {
            roundBonus = 150;
        } else {
            roundBonus = 200;
        }

        if (timeLeft >= 0 && timeLeft <= 12) {
            timeBonus = 50;
        } else if (timeLeft >= 13 && timeLeft <= 25) {
            timeBonus = 100;
        } else if (timeLeft >= 26 && timeLeft <= 37) {
            timeBonus = 150;
        } else {
            timeBonus = 200;
        }

        moneyBonus = rand.nextInt(timeBonus) + roundBonus;
        if (moneyBonus > 250) {
            moneyBonus = 250;
        }
        return moneyBonus;
    }
}
