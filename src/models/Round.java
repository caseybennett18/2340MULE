package models;

import java.util.ArrayList;

/**
 * Created by Admin on 9/24/15.
 */
public class Round {


    private Player currentPlayer;
    private int currentRound;
    private int playerIndex;
    private int turnPhase;

    private Player[] players;

    public Round(Player[] players) {
        this.currentRound = 0;
        this.currentPlayer = null;
        this.turnPhase = 0;
    }


    public void nextPlayer() {

    }

    public void nextTurnPhase() {
        turnPhase++;
    }




}
