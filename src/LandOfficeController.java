import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import models.Map;
import models.Player;
import models.Round;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by clint on 10/14/15.
 */
public class LandOfficeController {

    private Round round;

    @FXML
    Button buyLandGrantButton;

    public LandOfficeController() {
        round = MapScreenController.getInstance().getCurrentRound();
    }

    @FXML
    public void buyLandGrant() throws Exception {
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

    @FXML
    public void handleLandOffice() throws Exception {
        MuleUI.getInstance().loadLandOffice();
    }


    @FXML
    public void handleTown() throws Exception {
        MuleUI.getInstance().loadTown();
    }


    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }
}
