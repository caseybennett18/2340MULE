package main.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import main.MuleUI;
import main.models.ModelFacade;
import main.models.Mule;
import main.models.Player;
import javafx.scene.control.Button;

import javax.swing.*;

/**
* Controller for StartScreenController view
* 
*/
public class StartScreenController implements Initializable {
     
    @FXML
    Button startButton;

    @FXML
    ImageView mule;



// --Commented out by Inspection START (11/5/2015 9:37 PM):
//    @FXML
//    Button beginnerButton;
// --Commented out by Inspection STOP (11/5/2015 9:37 PM)
    @FXML
    Button standardButton;
    @FXML
    Button tournamentButton;
    @FXML
    Button onePlayerButton;
    @FXML
    Button twoPlayersButton;
    @FXML
    Button fourPlayersButton;


    private int numPlayers;
    private int difficulty;

    public int getNumPlayers() {
        return numPlayers;
    }

    public int getDifficulty() {
        return difficulty;
    }

    /**
    * @param event
    *           load screen based on saved settings
    */
    @FXML
    private void handleStart(ActionEvent event) {
        this.saveSettings();
        MuleUI.getInstance().loadSelect();
    }

    @FXML
    private void animate() {
        //mule.setRotate(20);
        Rectangle rect = new Rectangle (100, 40, 100, 100);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        rect.setFill(Color.VIOLET);

        RotateTransition rt = new RotateTransition(Duration.millis(3000), rect);
        rt.setByAngle(180);
        rt.setCycleCount(4);
        rt.setAutoReverse(true);

        rt.play();


        System.out.print("rotated");
        RotateTransition tt = new RotateTransition(Duration.seconds(30), mule);
        tt.setByAngle(360);
        tt.setCycleCount(Timeline.INDEFINITE);
        tt.setInterpolator(Interpolator.LINEAR);
        tt.play();
    }


    @FXML
    private void handleInstructions(ActionEvent event) throws Exception {
        MuleUI.getInstance().loadInstructions();
    }

    @FXML
    private void goBack(ActionEvent event) throws Exception {
        MuleUI.getInstance().loadMainMenu();
    }

    /**
    * @param e
    * @throws exception
    *               loads game
    */
    @FXML
    private void loadGame(ActionEvent e) throws Exception {
        ModelFacade model = new ModelFacade();
        ModelFacade.getInstance().loadModelText();
        MuleUI.getInstance().loadMap();
    }

    /**
    * @param url, rb
    */
    @FXML
    public void initialize(URL url, ResourceBundle rb ) {
    }

    /**
    * numPlayers is set to 1 based on a toggle box
    */
    @FXML
    public void numPlayersOne() {
        this.numPlayers = 1;

    }

    /**
    * numPlayers is set to 2 based on a toggle box
    */
    @FXML
    public void numPlayersTwo() {
        this.numPlayers = 2;

    }
    /**
    * numPlayers is set to 4 based on a toggle box
    */
    @FXML
    public void numPlayersFour() {
        this.numPlayers = 4;

    }

    /**
    * difficulty is set to beginner based on a toggle box
    */
    @FXML
    public void setBeginnerButton() {
        this.difficulty = 0;

    }

    /**
    * difficulty is set to standard based on a toggle box
    */
    @FXML
    public void setStandardButton() {
        this.difficulty = 1;
    }

    /**
    * difficulty is set to tournament based on a toggle box
    */
    @FXML
    public void setTournamentButton() {
        this.difficulty = 2;
    }

    /**
    * Takes settings inputted into view and sets the appropriate values in the
    * GameUI singleton instance
    */
    private void saveSettings() {
        MuleUI.getInstance().setnumPlayers(this.numPlayers);
        MuleUI.getInstance().setDifficulty(this.difficulty);
        createPlayers();
    }

    /**
    * creates an array of players with the length of numPlayers
    */
    public void createPlayers() {
        for (int i = 0; i < this.numPlayers; i++) {
            Player p = new Player(i);
            if (this.difficulty == 0) {
                p.setFood(8);
                p.setEnergy(4);
                p.setOre(0);
            } else {
                p.setFood(4);
                p.setEnergy(2);
                p.setOre(0);
            }
            MuleUI.getInstance().setPlayerArray(p, i);
        }
    }

    /**
    * sets the default settings to one player and beginner difficulty
    */
    public StartScreenController() {
        this.numPlayers = 1;
        this.difficulty = 0;
        this.animate();
    }
}   
  