package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.MuleUI;
import main.models.Player;
import main.models.Round;

import java.net.URL;
import java.util.ResourceBundle;



public class AssayOfficeController {

    private final Round round;

    @FXML
    Button buyCrystite;

    public AssayOfficeController() {
        round = MapScreenController.getInstance().getCurrentRound();
    }

    /**
     * buyLandGrant method: gets the current player, the land price, available land, and if you have money, you can purchase land.
     * Throws Exception
     * Return Type: Void
     */
    @FXML
    public void buyCrystite() {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        System.out.print("bought crystite");
        int pMoney = p.getMoney();
        if (pMoney >= 100) {
            p.setMoney(p.getMoney() - 100);
            p.setCrystite(p.getCrystite() + 1);
        }
    }


    /**
     * handleLandOffice method: loads the land office.
     * Throws Exception
     * Return Type: Void
     */

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

}
