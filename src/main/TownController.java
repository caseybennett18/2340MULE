package main;

import javafx.fxml.FXML;

/**
 * Controller for TownController view
 * 
 */
public class TownController {

    public TownController() {}

    /**
    * @throws exception
    *               loads button for pub
    */
    @FXML
    public void handlePub() throws Exception {
        MuleUI.getInstance().loadPub();
    }

    /**
    * @throws exception
    *               loads button for store
    */
    @FXML
    public void handleStore() throws Exception {
        MuleUI.getInstance().loadStore();
    }

    /**
    * @throws exception
    *               loads button for land office
    */
    @FXML
    public void handleLandOffice() throws Exception {
        MuleUI.getInstance().loadLandOffice();
    }

    /**
    * back to map button
    */
    @FXML
    public void handleMap() {
        MuleUI.getInstance().loadMap();
    }
}
