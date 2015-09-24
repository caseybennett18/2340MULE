 import java.net.URL;
 import java.util.ResourceBundle;

 import javafx.scene.Group;
 import javafx.scene.layout.AnchorPane;
 import models.Map;
 import javafx.event.*;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.image.Image;
 import javafx.scene.layout.GridPane;
 import javafx.scene.control.Button;
 import javafx.scene.layout.HBox;
 import javafx.scene.layout.VBox;

 import javafx.scene.image.ImageView;



 public class MapScreenController implements Initializable {
     
    @FXML
    GridPane gridpane;

     @FXML
     AnchorPane anchorpane;

     private final static int TILE_WIDTH = 78;
     private final static int TILE_HEIGHT = 120;
    
    public MapScreenController() {
    }


     @FXML
     public void handleTown() throws Exception {
         MuleUI.getInstance().loadTown();
     }
    
    @FXML
    private void handleBuyLand(ActionEvent event) {
        Button button = (Button) event.getSource();
//        DropShadow ds = new DropShadow(20, javafx.scene.paint.Color.CYAN);
//        button.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED,
//                new EventHandler<javafx.scene.input.MouseEvent>() {
//                    @Override
//                    public void handle(javafx.scene.input.MouseEvent event) {
//                        button.setEffect(ds);
//                    }
//                });
    }

     private void addMap(VBox vbox) {
         Map map = new Map();
         String[][] tileFileNames = map.getTileImages();
         for (int i = 0; i < tileFileNames.length; i++) {
             HBox box = new HBox();
             for (int j = 0; j < tileFileNames[i].length; j++) {
                 Image image = new Image(tileFileNames[i][j]);
                 ImageView view = new ImageView();
                 view.setImage(image);
                 view.setFitWidth(TILE_WIDTH);
                 view.setFitHeight(TILE_HEIGHT);
                 view.setSmooth(true);
                 view.setCache(true);
                 box.getChildren().add(view);
             }
             vbox.getChildren().add(box);
         }
     }

     private void generateScreen() {
         Group root = new Group();
         VBox vbox = new VBox();
         addMap(vbox);
         //addPromptLabel(vbox);
         //addDescriptionLabel(vbox);
         //addPlayerLabels(vbox);
         root.getChildren().add(vbox);
         anchorpane.getChildren().add(root);
         root.setFocusTraversable(true);
         //root.setOnKeyPressed(new KeyPressedHandler());
         //passButton.toFront();
     }



    @FXML
    public void initialize(URL url, ResourceBundle rb ) {
    }

}   
  