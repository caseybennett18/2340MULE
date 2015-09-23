package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import game.*;
import driver.*;

public class MapController {
    public final static int MAP_SIZE = 700;
    public final static int WIDTH = 78;
    public final static int HEIGHT = 120;
   
    @FXML
    Button passButton;

    @FXML
    AnchorPane anchorPane;

    public void initialize(URL url, ResourceBundle rb) {
        drawScreen();
        drawProperyColors();
    }

    private void drawScreen() {
        Group root = new Group();
        Vbox = new Vbox();
        root.getChildren().add(vbox);
        anchorPane.getChildren.add(root);
        root.setFocusTraversable(true);
        passButton.toFront();
    }
}
