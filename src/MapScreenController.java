 import java.net.URL;
 import java.util.ResourceBundle;

 import javafx.animation.AnimationTimer;
 import javafx.animation.KeyFrame;
 import javafx.animation.Timeline;
 import javafx.scene.Group;
 import javafx.scene.control.Label;
 import javafx.scene.control.ProgressBar;
 import javafx.scene.effect.ColorAdjust;
 import javafx.scene.image.ImageView;
 import javafx.scene.input.MouseEvent;
 import javafx.scene.layout.AnchorPane;
 import javafx.event.*;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.layout.BorderPane;
 import javafx.scene.layout.GridPane;
 import javafx.scene.control.Button;
 import javafx.scene.layout.VBox;

 import javafx.scene.paint.Color;
 import javafx.scene.shape.Circle;
 import javafx.scene.text.TextFlow;
 import javafx.util.Duration;
 import models.Player;
 import models.Round;

 import javax.swing.*;


 public class MapScreenController implements Initializable {
     
    @FXML
    GridPane gridpane;

     @FXML
     AnchorPane anchorpane;

     @FXML
     TextFlow textflow;

     @FXML
     BorderPane borderpane;

     private ImageView iv;
     private Timeline timeline;
     private int timeSeconds;

     private Label timerLabel;

     private final static int STARTTIME = 30;

     private final static int TILE_WIDTH = 78;
     private final static int TILE_HEIGHT = 120;
     private Player[] players;
     private Round round;
     private Button clickedButton;
    
    public MapScreenController() {
        this.players = MuleUI.getInstance().getPlayerArray();
        this.round = new Round(players);
        this.timerLabel = new Label();
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

     public void addPlayerDescriptions(TextFlow tf) {
         VBox vboxx = new VBox();
         Round round = new Round(players);
         Label playerTurnLabel = new Label("Click on Button to Start Land Selection Phase!");
         vboxx.getChildren().add(playerTurnLabel);

         Button nextButton = new Button();
         nextButton.setText("Next Player's Turn");
         nextButton.setOnMouseClicked(new NextButtonPressedHandler());
         nextButton.setOnMouseReleased(new TimerHandler());
         vboxx.getChildren().add(nextButton);

         tf.getChildren().add(vboxx);
     }

    private void generateScreen() {
        Group root = new Group();

        VBox vbox = new VBox(); //has another vbox with a label and a button
        addPlayerDescriptions(textflow);
        textflow.getChildren().addAll(timerLabel);
        root.getChildren().add(vbox);//root has one vbox

        anchorpane.getChildren().add(root);//has a group
    }


     private class NextButtonPressedHandler implements EventHandler<MouseEvent> {
        private Player[] playersHere = MuleUI.getInstance().getPlayerArray();
         private Round roundHere = new Round(playersHere);

         public void handle(MouseEvent me) {
             clickedButton = (Button) me.getSource();
             if (!(clickedButton.isDisabled())) {
                 if (round.turnPhase == players.length) {
                     round.currentRound++;
                     System.out.println("round.currentround");
                     System.out.println(round.currentRound);
                 }
                 if (round.turnPhase <= players.length - 1) {
                     TextFlow root = (TextFlow) borderpane.getChildren().get(2);
                     VBox vbox2 = (VBox) root.getChildren().get(0);
                     Label pLabel = (Label) vbox2.getChildren().get(0);
                     pLabel.setText("It is now " + players[round.turnPhase].getPlayerName() + "'s turn!");
                     round.turnPhase++;
                     System.out.println("round.turnphase");
                     System.out.println(round.turnPhase);
                 } else {
                     round.turnPhase = 0;
                     TextFlow root = (TextFlow) borderpane.getChildren().get(2);
                     VBox vbox2 = (VBox) root.getChildren().get(0);
                     Label pLabel = (Label) vbox2.getChildren().get(0);
                     pLabel.setText("It is now " + players[round.turnPhase].getPlayerName() + "'s turn!");
                     round.turnPhase++;
                 }
                 if (round.currentRound > 1) {
                     TextFlow root = (TextFlow) borderpane.getChildren().get(2);
                     VBox vbox2 = (VBox) root.getChildren().get(0);
                     Label pLabel = (Label) vbox2.getChildren().get(0);
                     pLabel.setText("Land Selection Phase is now over.");
                 }
                 System.out.println("Money: " + players[round.turnPhase-1].getMoney());
                 System.out.println("Food: " + players[round.turnPhase-1].getFood());
                 System.out.println("Energy: " + players[round.turnPhase-1].getEnergy());
                 System.out.println("Ore: " + players[round.turnPhase-1].getOre());
             }

         }
     }

     private class TimerHandler implements EventHandler<MouseEvent> {

         public void handle(MouseEvent me) {
             if (timeline != null) {
                 timeline.stop();
             }
             timeSeconds = STARTTIME;

             timerLabel.setText("Time remaining in turn - " + timeSeconds);
             timeline = new Timeline();
             timeline.setCycleCount(Timeline.INDEFINITE);
             timeline.getKeyFrames().add(
                     new KeyFrame(Duration.seconds(1),
                     new EventHandler<ActionEvent>() {
                         public void handle(ActionEvent event) {
                             timeSeconds--;
                             timerLabel.setText("Time remaining in turn - " + timeSeconds);
                             if (timeSeconds <= 0) {
                                 timeline.stop();
                             }
                         }

                     }
             ));
             timeline.playFromStart();

         }
     }


    @FXML
    public void initialize(URL url, ResourceBundle rb ) {
        generateScreen();
    }

}   
  