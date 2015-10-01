import javafx.fxml.FXML;

/**
 * Created by clint on 9/30/15.
 */
public class TownController {

    public TownController() {}

    @FXML
    public void handlePub() throws Exception {
        MuleUI.getInstance().loadPub();
    }

    @FXML
    public void handleMap() throws Exception {
        MuleUI.getInstance().loadMap();
    }

}
