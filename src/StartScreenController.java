 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import models.Player;
 import javafx.scene.control.Button;
 import java.io.IOException;

 
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
     
     @FXML
     private void handleStart(ActionEvent event) throws Exception {
         this.saveSettings();
         MuleUI.getInstance().loadSelect();
    }


     @FXML
     public void initialize(URL url, ResourceBundle rb ) {
     }

     @FXML
     public void numPlayersOne() {
         this.numPlayers = 1;

     }

     @FXML
     public void numPlayersTwo() {
         this.numPlayers = 2;

     }

     @FXML
     public void numPlayersFour() {
         this.numPlayers = 4;

     }

     @FXML
     public void setBeginnerButton() {
         this.difficulty = 0;
         System.out.println("button one");

     }

     @FXML
     public void setStandardButton() {
         this.difficulty = 1;
     }

     @FXML
     public void setTournamentButton() {
         this.difficulty = 2;
     }

     private void saveSettings() {
         MuleUI.getInstance().setnumPlayers(this.numPlayers);
         MuleUI.getInstance().setDifficulty(this.difficulty);
         createPlayers();
     }

     private void createPlayers() {
         for (int i = 0; i < this.numPlayers; i++) {
             Player p = new Player(i);
             MuleUI.getInstance().setPlayerArray(p, i);
         }
     }

     public StartScreenController() {
         this.numPlayers = 1;
         this.difficulty = 0;
     }
}   
  