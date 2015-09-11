/*
 * MULE Application
 * @author Charles Marcus
 * @version 1.0
 *
 */
 
 import javafx.application.Application;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.stage.Stage;
 
 public class MULEApp extends Application {
     
     public void start(Stage stage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("MULEStartScreen.fxml"));
         
         Scene scene = new Scene(root);
         
         stage.setScene(scene);
         stage.setTitle("M.U.L.E on Atari");
         stage.show();
     }
 }
 
 