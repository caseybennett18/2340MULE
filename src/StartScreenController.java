 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.Label;
 import javafx.scene.*;
 import javafx.stage.Stage;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.control.Button;
 import java.io.IOException;

 
 public class StartScreenController implements Initializable {
     
     @FXML
     Button startButton;
     /*
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
     */
     
     @FXML
     private void handleStart(ActionEvent event) throws Exception {
         MuleUI.getInstance().loadSelect();
    }
    
    public void initialize(URL url, ResourceBundle rb ) {
    }
    
}   
  