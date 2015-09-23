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

 
 public class SelectScreenController implements Initializable {
     
     @FXML 
     Button continueButton;
     
     public void handleContinue() throws Exception {
         MuleUI.getInstance().loadMap();
     }


     
     public void initialize(URL url, ResourceBundle rb ) {
    }
 }