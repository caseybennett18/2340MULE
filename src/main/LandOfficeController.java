package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.models.Player;
import main.models.Round;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by clint on 10/14/15.
 */
public class LandOfficeController {

    private final Round round;

    @FXML
    Button buyLandGrantButton;

    public LandOfficeController() {
        round = MapScreenController.getInstance().getCurrentRound();
    }

    @FXML
    public void buyLandGrant() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        int landPrice = round.getLandPrice();
        ArrayList<Button> allOwnedLand = MapScreenController.getInstance().getAllOwnedLands();
        int numLandAvailable = 45 - allOwnedLand.size();
        if (p.getMoney() >= landPrice && numLandAvailable > 0) {
            p.incrementNumLandGrants();
            p.setMoney(p.getMoney() - landPrice);
            p.updatePlayerScore();
            System.out.println("Player " + p.getPlayerName() + " has " + p.getNumLandGrants() + " land grants");
            System.out.println("Land Price: " + landPrice);
        }
    }

// --Commented out by Inspection START (11/5/2015 9:25 PM):
//    @FXML
//    public void handleLandOffice() throws Exception {
//        MuleUI.getInstance().loadLandOffice();
//    }
// --Commented out by Inspection STOP (11/5/2015 9:25 PM)


    @FXML
    public void handleTown() throws Exception {
        MuleUI.getInstance().loadTown();
    }


// --Commented out by Inspection START (11/5/2015 9:25 PM):
//    @FXML
//    public void initialize(URL url, ResourceBundle rb) {
//    }
// --Commented out by Inspection STOP (11/5/2015 9:25 PM)
}
