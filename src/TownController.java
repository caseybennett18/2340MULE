import javafx.fxml.FXML;
import models.Mule;

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
    public void handleStore() throws Exception {
        MuleUI.getInstance().loadStore();
    }

    @FXML
    public void handleLandOffice() throws Exception {
        MuleUI.getInstance().loadLandOffice();
    }

    @FXML
    public void handleMap() throws Exception {
        MuleUI.getInstance().loadMap();
    }
}
