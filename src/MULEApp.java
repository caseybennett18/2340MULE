/*
 * MULE Application
 * @author Charles Marcus
 * @version 1.0
 *
 */
 
 
 import javafx.application.Application;
 import javafx.fxml.FXMLLoader;
 //import MULEStartScreenController.;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.stage.Stage;
  import java.io.IOException;
 
 public class MULEApp extends Application {
     
     public void start(Stage stage) throws Exception {
         
         try {
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MULEApp.class.getResource("MULEStartScreen.fxml"));
             Parent root = FXMLLoader.load(getClass().getResource("MULEStartScreen.fxml"));
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.setTitle("M.U.L.E on Atari");
             
             MULEStartScreenController controller = loader.getController();
             stage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     
     public static void main(String[] args) {
         launch(args);
     }
 }
 
 