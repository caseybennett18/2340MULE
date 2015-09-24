 import java.net.URL;
 import java.util.ResourceBundle;

 import javafx.scene.Group;
 import javafx.scene.control.Label;
 import javafx.scene.effect.ColorAdjust;
 import javafx.scene.image.ImageView;
 import javafx.scene.input.MouseEvent;
 import javafx.scene.layout.AnchorPane;
 import javafx.event.*;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.layout.GridPane;
 import javafx.scene.control.Button;
 import javafx.scene.layout.VBox;

 import javafx.scene.paint.Color;
 import javafx.scene.shape.Circle;
 import models.Player;
 import models.Round;


 public class MapScreenController implements Initializable {
     
    @FXML
    GridPane gridpane;

     @FXML
     AnchorPane anchorpane;

     private ImageView iv;

     private final static int TILE_WIDTH = 78;
     private final static int TILE_HEIGHT = 120;
     private Player[] players;
     private Round round;
     private Button clickedButton;
    
    public MapScreenController() {
        this.players = MuleUI.getInstance().getPlayerArray();
        this.round = new Round(players);
    }


     @FXML
     public void handleTown() throws Exception {
         MuleUI.getInstance().loadTown();
     }
    
    @FXML
    private void handleBuyLand(ActionEvent event) {
        clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-border-color:" + players[round.turnPhase-1].getPlayerColor() +"; -fx-background-color: transparent; -fx-border-width: 6px;");
        clickedButton.setDisable(true);
    }


//     private class LandButtonClickedHandler implements EventHandler<MouseEvent> {
//
//         public void handle(MouseEvent me) {
//             ImageView iv = getImageViewFromCoordinates(me.getX(), me.getY());
//             System.out.println(iv);
//             Circle c = new Circle();
//             ///c.setCenterX(me.getSceneX());
//             //c.setCenterY(me.getSceneY());
//             c.setRadius(4);
//             c.setStroke(Color.RED);
//             ColorAdjust adjuster = new ColorAdjust();
//             adjuster.setBrightness(0.6);
//             iv.setEffect(adjuster);
//
//            //anchorpane.add(c, (int) me.getSceneX(), (int) me.getSceneY());
//             //TODO create some sort of land marker for players
//         }
//     }

     private ImageView getImageViewFromCoordinates(double x, double y) {
         GridPane root = (GridPane) anchorpane.getChildren().get(0);
         ImageView iv = (ImageView) root.getChildren().get(0);

         return iv;
     }

     public void addPlayerDescriptions(VBox vbox) {
         VBox vboxx = new VBox();
         Round round = new Round(players);
         Label playerTurnLabel = new Label("Click on Button to Start Land Selection Phase!");
         vboxx.getChildren().add(playerTurnLabel);

         Button nextButton = new Button();
         nextButton.setText("Next Player's Turn");
         nextButton.setOnMouseClicked(new NextButtonPressedHandler());
         vboxx.getChildren().add(nextButton);

         vbox.getChildren().add(vboxx);
     }

    private void generateScreen() {
        Group root = new Group();
        VBox vbox = new VBox(); //has another vbox with a label and a button
        addPlayerDescriptions(vbox);
        root.getChildren().add(vbox);//root has one vbox
        anchorpane.getChildren().add(root);//has a group
    }


     private class NextButtonPressedHandler implements EventHandler<MouseEvent> {
        private Player[] playersHere = MuleUI.getInstance().getPlayerArray();
         private Round roundHere = new Round(playersHere);

         public void handle(MouseEvent me) {
             clickedButton = (Button) me.getSource();
             if (!(clickedButton.isDisabled())) {

                 if (round.turnPhase <= players.length - 1) {
                     System.out.println(round.turnPhase);
                     Group root = (Group) anchorpane.getChildren().get(1);
                     VBox vbox = (VBox) root.getChildren().get(0);
                     VBox vbox2 = (VBox) vbox.getChildren().get(0);
                     Label pLabel = (Label) vbox2.getChildren().get(0);
                     pLabel.setText("It is now " + players[round.turnPhase].getPlayerName() + "'s turn!");
                     round.turnPhase++;
                 } else {
                     round.turnPhase = 0;
                     Group root = (Group) anchorpane.getChildren().get(1);
                     VBox vbox = (VBox) root.getChildren().get(0);
                     VBox vbox2 = (VBox) vbox.getChildren().get(0);
                     Label pLabel = (Label) vbox2.getChildren().get(0);
                     pLabel.setText("It is now " + players[round.turnPhase].getPlayerName() + "'s turn!");
                     round.turnPhase++;
                 }
                 if (round.turnPhase == players.length) {
                     round.currentRound++;
                 }

                 if (round.currentRound > 1) {
                     Group root = (Group) anchorpane.getChildren().get(1);
                     VBox vbox = (VBox) root.getChildren().get(0);
                     VBox vbox2 = (VBox) vbox.getChildren().get(0);
                     Label pLabel = (Label) vbox2.getChildren().get(0);
                     pLabel.setText("Land Selection Phase is now over.");
                 }
             }
         }
     }

    @FXML
    public void initialize(URL url, ResourceBundle rb ) {
        generateScreen();
    }

}   
  