 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.Label;
 import javafx.scene.*;
 import javafx.scene.control.MenuItem;
 import javafx.stage.Stage;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.control.Button;
 import java.io.IOException;

 
 public class StartScreenController implements Initializable {
     
     @FXML
     Button startButton;

     @FXML
     MenuItem beginnerButton;
     @FXML
     MenuItem standardButton;
     @FXML
     MenuItem tournamentButton;
     @FXML
     MenuItem onePlayerButton;
     @FXML
     MenuItem twoPlayersButton;
     @FXML
     MenuItem fourPlayersButton;


     private int numPlayers;
     
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
         numPlayers = 1;
     }

     @FXML
     public void numPlayersTwo() {
         numPlayers = 2;
     }

     @FXML
     public void numPlayersFour() {
         numPlayers = 4;
     }

     public void saveSettings() {
         MuleUI.getInstance().setnumPlayers(numPlayers);
     }
}   
  