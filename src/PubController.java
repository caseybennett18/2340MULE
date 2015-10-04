

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import models.Gamble;
import models.Player;
import models.Round;
import models.Timer;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by clint on 9/30/15.
 */
public class PubController implements Initializable {

    @FXML
    Button gambleButton;

    private Gamble gamble;
    private Random rand;
    private Round round;
    private Timer timer;

    public PubController() {
        gamble = new Gamble();
        rand = new Random();
        timer = new Timer();
        round = new Round(MuleUI.getInstance().getPlayerArray());
    }

    @FXML
    public void gamble() throws Exception {
        int winnings = gamble.calculateBonus(timer.getTime(), round.currentRound);
        Player p = MuleUI.getInstance().getPlayerArray()[round.turnPhase];
        System.out.println("Player Name: " + p.getPlayerName());
        System.out.println("$$$ before = " + p.getMoney());
        p.setMoney(p.getMoney() + winnings);
        System.out.println("$$$ after = " + p.getMoney());
    }

    @FXML
    public void handlePub() throws Exception {
        MuleUI.getInstance().loadPub();
    }


    @FXML
    public void handleTown() throws Exception {
        MuleUI.getInstance().loadTown();
    }


    @FXML
    public void initialize(URL url, ResourceBundle rb) {

    }
}
