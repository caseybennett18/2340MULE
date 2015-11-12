/*
 * M.U.L.E Start Screen in JavaFX, using SceneBuilder Template.
 * @author Charles Marcus
 * @version 1.0
 */
 
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

 
 public  class MULEStartScreenController implements Initializable {
     
     @FXML
     private Button button;
     
     @FXML
     private Button button2;
     
     @FXML
     private void handleButtonAction(ActionEvent event) throws IOException {
         
         Stage stage = null;
         Parent root;
         
         if (event.getSource() == button) {
             stage = (Stage) button.getScene().getWindow();
             root = FXMLLoader.load(getClass().getResource("PlayerSelectScreen.fxml"));
        } else {
             stage = (Stage) button2.getScene().getWindow();
             root = FXMLLoader.load(getClass().getResource("MapScreen.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void initialize(URL url, ResourceBundle rb ) {
        
    }
    
}   
  