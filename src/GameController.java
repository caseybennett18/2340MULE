import models.Round;
import models.Player;

/**
 * Created by Admin on 9/24/15.
 */
public class GameController {


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
