package main.models;

import java.util.Random;

/**
 * Created by Admin on 9/24/15.
 */
public class Round {


    private Player currentPlayer;
    public int currentRound;
    private int playerIndex;
    public int turnPhase;
    private Random rand;
    public int landPrice;

    private Player[] players;

    public Round(Player[] players) {
        rand = new Random();
        this.currentRound = 0;
        this.currentPlayer = null;
        this.turnPhase = 0;
        landPrice = 300;
    }

    public Round() {
        rand = new Random();
        this.currentRound = 0;
        this.currentPlayer = null;
        this.turnPhase = 0;
        landPrice = 300;
    }


    public void nextPlayer() {

    }

    public void nextTurnPhase() {
        turnPhase++;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int round) {currentRound = round;}

    public Player getCurrentPlayer() {
        if (turnPhase == 0 ) {
            return players[turnPhase];
        } else {
            return players[turnPhase - 1];
        }
    }

    public int getNextRound() {
        return currentRound++;
    }

    public void nextRound() {
        currentRound++;
        setLandPrice(300 + (currentRound * rand.nextInt(100)));
    }

    public void setLandPrice(int price) {
        landPrice = price;
    }

    public int getLandPrice() {
        return landPrice;
    }
}
