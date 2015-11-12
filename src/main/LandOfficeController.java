package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.models.Map;
import main.models.Player;
import main.models.Round;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by clint on 10/14/15.
 * LandOfficeController Class: FXML controller for Land Office where you can buy land.
 */
public class LandOfficeController {

    private final Round round;

    @FXML
    Button buyLandGrantButton;

    public LandOfficeController() {
        round = MapScreenController.getInstance().getCurrentRound();
    }

    /**
     * buyLandGrant method: gets the current player, the land price, available land, and if you have money, you can purchase land.
     * Throws Exception
     * Return Type: Void
     */
    @FXML
    public void buyLandGrant() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        int landPrice = round.getLandPrice();
        boolean isLandAvailable = MapScreenController.getInstance().isLandAvailable();
        //ArrayList<Button> allOwnedLand = MapScreenController.getInstance().getAllOwnedLands();
        //int numLandAvailable = 44 - allOwnedLand.size();
        if (p.getMoney() >= landPrice && isLandAvailable) {
            p.incrementNumLandGrants();
            p.setMoney(p.getMoney() - landPrice);
            p.updatePlayerScore();
            System.out.println("Player " + p.getPlayerName() + " has " + p.getNumLandGrants() + " land grants");
            System.out.println("Land Price: " + landPrice);
        }
    }


    /**
     * handleLandOffice method: loads the land office.
     * Throws Exception
     * Return Type: Void
     */
    @FXML
    public void handleLandOffice() throws Exception {
        MuleUI.getInstance().loadLandOffice();
    }

// --Commented out by Inspection START (11/5/2015 9:25 PM):
//    @FXML
//    public void handleLandOffice() throws Exception {
//        MuleUI.getInstance().loadLandOffice();
//    }
// --Commented out by Inspection STOP (11/5/2015 9:25 PM)


    /**
     * handleLandOffice method: loads the land office.
     * Throws Exception
     * Return Type: Void
     */
    @FXML
    public void handleTown() throws Exception {
        MuleUI.getInstance().loadTown();
    }


    /**
     * initialize Method
     * Param: URL url and ResourceBundle rb
     * Return Type: Void
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }


// --Commented out by Inspection START (11/5/2015 9:25 PM):
//    @FXML
//    public void initialize(URL url, ResourceBundle rb) {
//    }
// --Commented out by Inspection STOP (11/5/2015 9:25 PM)

}
