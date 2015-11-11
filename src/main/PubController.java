package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.models.Player;
import main.models.Round;
import main.models.Timer;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

/**
* Controller for PubController view
* 
*/
public class PubController implements Initializable {

    @FXML
    Button gambleButton;


    private final Gamble gamble;
    // --Commented out by Inspection (11/5/2015 9:33 PM):private final Random rand;
    private final Round round;
    private final Timer timer;

    /**
     * constructor for PubController
     *
     */
    public PubController() {
        gamble = new Gamble();
        //rand = new Random();
        timer = MapScreenController.getInstance().getTimer();
        round = MapScreenController.getInstance().getCurrentRound();
    }

    /**
    * updates playerScore based on winnings
    */
    @FXML
    public void gamble() {
        int winnings = gamble.calculateBonus(timer.getTime(), round.currentRound);
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        System.out.println("Player Name: " + p.getPlayerName());
        System.out.println("$$$ before = " + p.getMoney());
        p.setMoney(p.getMoney() + winnings);
        System.out.println("$$$ after = " + p.getMoney());
        MapScreenController.getInstance().nextTurn();
        p.updatePlayerScore();
        MuleUI.getInstance().loadMap();
    }

// --Commented out by Inspection START (11/5/2015 9:34 PM):
//    @FXML
//    public void handlePub() throws Exception {
//        MuleUI.getInstance().loadPub();
//    }
// --Commented out by Inspection STOP (11/5/2015 9:34 PM)

    /**
    * loads back to town button
    */
    @FXML
    public void handleTown() {
        MuleUI.getInstance().loadTown();
    }

    /**
    * @param url, rb
    */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {

    }
}
