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
 import models.Timer;

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
     private Timer timer;

     private Label timerLabel;

     private final static int TILE_WIDTH = 78;
     private final static int TILE_HEIGHT = 120;
     private Player[] players;
     private Round round;
     private Button clickedButton;
     protected boolean timeRanOut = false;
    
    public MapScreenController() {
        this.players = MuleUI.getInstance().getPlayerArray();
        MuleUI.getInstance().getPlayerOrder(players);
        this.round = new Round(players);
        this.timerLabel = new Label();
        timer = new Timer();
    }


     @FXML
     public void handleTown() throws Exception {
         MuleUI.getInstance().loadTown();
     }
    
    @FXML
    private void handleBuyLand(ActionEvent event) {
        Player currentPlayer = players[round.turnPhase-1];
        if (!currentPlayer.hasPicked()) {
            clickedButton = (Button) event.getSource();
            clickedButton.setStyle("-fx-border-color:" + currentPlayer.getPlayerColor() + "; -fx-background-color: transparent; -fx-border-width: 6px;");
            clickedButton.setDisable(true);
            currentPlayer.setHasPicked(true);
            currentPlayer.incrementNumProperties();
        }
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
         //nextButton.setOnMousePressed((new PlayerDescriptionHandler()));
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

        //final TimerHandler timerHandler = new TimerHandler();
        //private Player[] playersHere = MuleUI.getInstance().getPlayerArray();
        //private Round roundHere = new Round(playersHere);

        public void nextTurn() {
            //going to next round
            if (round.turnPhase == players.length) {
                round.currentRound++;
                for (Player p : players) {
                    if (round.currentRound < 2) {
                        p.setHasPicked(false);
                    }
                    p.updatePlayerScore();
                }
                MuleUI.getInstance().getPlayerOrder(players);
                System.out.println("round.currentround");
                System.out.println(round.currentRound);
            }

            //round is still happening
            if (round.turnPhase <= players.length - 1) {
                TextFlow root = (TextFlow) borderpane.getChildren().get(2);
                VBox vbox2 = (VBox) root.getChildren().get(0);
                Label pLabel = (Label) vbox2.getChildren().get(0);
                pLabel.setText("It is now " + players[round.turnPhase].getPlayerName() + "'s turn!");
                players[round.turnPhase].updatePlayerScore();
                round.turnPhase++;
                System.out.println("round.turnphase");
                System.out.println(round.turnPhase);

                //getting ready for next round
            } else {
                round.turnPhase = 0;
                TextFlow root = (TextFlow) borderpane.getChildren().get(2);
                VBox vbox2 = (VBox) root.getChildren().get(0);
                Label pLabel = (Label) vbox2.getChildren().get(0);
                pLabel.setText("It is now " + players[round.turnPhase].getPlayerName() + "'s turn!");
                players[round.turnPhase].updatePlayerScore();
                round.turnPhase++;
            }

            //
            if (round.currentRound > 1) {
                TextFlow root = (TextFlow) borderpane.getChildren().get(2);
                VBox vbox2 = (VBox) root.getChildren().get(0);
                Label pLabel = (Label) vbox2.getChildren().get(0);
                pLabel.setText("Land Selection Phase is now over.");
            }

            System.out.println("Score: " + players[round.turnPhase-1].getScore());
            System.out.println("Money: " + players[round.turnPhase-1].getMoney());
            System.out.println("Food: " + players[round.turnPhase-1].getFood());
            System.out.println("Energy: " + players[round.turnPhase-1].getEnergy());
            System.out.println("Ore: " + players[round.turnPhase-1].getOre());
        }


         public void handle(MouseEvent me) {
             clickedButton = (Button) me.getSource();
             if (!(clickedButton.isDisabled())) {
                     nextTurn();
             }

             if (timeRanOut) {
                 timer.setTime(10);
                 timeRanOut = false;
             }
         }
     }

     private class TimerHandler implements EventHandler<MouseEvent> {

         final NextButtonPressedHandler nextTurnHandler = new NextButtonPressedHandler();

         public void restartTimer() {
             if (timeline != null) {
                 timeline.stop();
             }

             timer.setTime(30);
             timerLabel.setText("Time remaining in turn - " + timer.getTime());
             timeline = new Timeline();
             timeline.setCycleCount(Timeline.INDEFINITE);
             timeline.getKeyFrames().add(
                     new KeyFrame(Duration.seconds(1),
                             new EventHandler<ActionEvent>() {
                                 public void handle(ActionEvent event) {
                                     timer.decrementTimer();
                                     timerLabel.setText("Time remaining in turn - " + timer.getTime());
                                     if (timer.getTime() <= 0) {
                                         timeline.stop();
                                         timeRanOut = true;
                                         nextTurnHandler.nextTurn();
                                         timer.setTime(31);
                                         timeline.playFromStart();
                                     }
                                 }

                             }
                     ));
             timeline.playFromStart();
         }

         public void handle(MouseEvent me) {
             restartTimer();
         }

     }

     private class PlayerDescriptionHandler implements EventHandler<MouseEvent> {

         public void handle(MouseEvent me) {
             int i = 0;
             VBox vbox = new VBox();
             for (Player cp: players) {
                 Label p = new Label("Player " + (i + 1) + ": " + cp.getPlayerName() + " | Score: "
                         + cp.getScore() + " | Money: " + cp.getMoney() + " | Ore: " + cp.getOre() + " | Food: " + cp.getFood());
                 vbox.getChildren().add(p);
             }
         }
     }


    @FXML
    public void initialize(URL url, ResourceBundle rb ) {
        generateScreen();
    }

}