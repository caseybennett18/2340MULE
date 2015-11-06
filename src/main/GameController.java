package main;

import main.models.Round;
import main.models.Player;

/**
 * Created by Admin on 9/24/15.
 * Game Controller Class: Round phases for each player based off of a player array
 */
public class GameController {

    /**
     * Game Controller: Round phases for each player based off of a player array
     * Param: none
     * Return Type: void
     */
    public void roundPhase() {
        Player[] players = MuleUI.getInstance().getPlayerArray();
        Round current = new Round(MuleUI.getInstance().getPlayerArray());
        for (Player currentPlayer: players) {
            MuleUI.getInstance().currentPlayer.setPlayerName(currentPlayer.getPlayerName());
            MuleUI.getInstance().currentPlayer.setRace(currentPlayer.getPlayerRace().toString());
            MuleUI.getInstance().currentPlayer.setPlayerColor(currentPlayer.getPlayerColor());
        }
    }
}
