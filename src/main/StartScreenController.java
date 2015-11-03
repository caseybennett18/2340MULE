package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.ModelFacade;
import main.models.Mule;
import main.models.Player;
import javafx.scene.control.Button;

/**
* Controller for StartScreenController view
* 
*/

public class StartScreenController implements Initializable {
     
    @FXML
    Button startButton;

    @FXML
    Button beginnerButton;
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
     
    /**
    * 
    * 
    */
    @FXML
    private void handleStart(ActionEvent event) throws Exception {
        this.saveSettings();
        MuleUI.getInstance().loadSelect();
    }


    @FXML
    private void loadGame(ActionEvent e) throws Exception {
        ModelFacade model = new ModelFacade();
        model.getInstance().loadModelText();
        MuleUI.getInstance().loadMap();
    }

    /**
    * Loads game
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
    * Takes settings inputed into view and sets the appropriate values in the
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
    private void createPlayers() {
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
    }
}   
  