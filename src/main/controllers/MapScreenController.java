package main.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
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

import javafx.scene.text.TextFlow;
import javafx.util.Duration;
import main.MuleUI;
import main.models.*;
import main.models.Event;


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
    boolean landSelectionPhaseOver = false;

    private static Tile tile;

    private final static int TILE_WIDTH = 78;
    private final static int TILE_HEIGHT = 120;

    private static MapScreenController instance;
    public Player[] players;
    private Round round;
    private Button clickedButton;
    private ArrayList<Button> allOwnedLands;
    private int allOwnedLands_size;
    protected boolean timeRanOut = false;
    final NextButtonPressedHandler nextTurnHandler = new NextButtonPressedHandler();

    private boolean alreadyPicked = false;

    public MapScreenController() {
        instance = this;
        this.players = MuleUI.getInstance().getPlayerArray();
        MuleUI.getInstance().getPlayerOrder(players);
        this.round = new Round(players);
        tile = new Tile();
        this.timerLabel = new Label();
        timer = new Timer();
        allOwnedLands = new ArrayList<>();
        System.out.println(players);
        updatePlayersScores(players);
    }

    public static MapScreenController getInstance() {
        return instance;
    }

    public void nextTurn() {
        nextTurnHandler.nextTurn();
    }

    public Player getCurrentPlayer() {
        if (round.turnPhase == 0) {
            return players[round.turnPhase];
        } else {
            return players[round.turnPhase - 1];
        }
    }

    public Round getCurrentRound() {
        return round;
    }

    public void setCurrentRound(Round round) {
        this.round = round;
    }

    public Timer getTimer() {
        return timer;
    }

    public ArrayList<Button> getAllOwnedLands() {
        return allOwnedLands;
    }

    public boolean isLandAvailable() {
        return allOwnedLands.size() < 45;
    }

    public void addLand(Button b) {
        allOwnedLands.add(b);
    }

    private void updatePlayersScores(Player[] players) {
        for (Player p: players) {
            p.updatePlayerScore();
        }
    }

    @FXML
    public void handleTown() throws Exception {
        MuleUI.getInstance().loadTown();
    }

    @FXML
    private void handleBuyLand(ActionEvent event) {
        Player currentPlayer = players[round.turnPhase-1];
        clickedButton = (Button) event.getSource();

        //first 2 rounds players get 1 land for free each turn
        //a player may NOT install a MULE on a land he/she owns
        if (round.currentRound < 2) {
            if (!currentPlayer.hasPicked()) {
                if (!allOwnedLands.contains(clickedButton)) {
                    allOwnedLands.add(clickedButton);
                    clickedButton.setStyle("-fx-border-color:" + currentPlayer.getPlayerColor() + "; -fx-background-color: transparent; -fx-border-width: 6px;");
                    currentPlayer.setHasPicked(true);
                    currentPlayer.addProperty(clickedButton);
                    tile.setTileLocationColor(clickedButton.getLayoutX(), clickedButton.getLayoutY(), currentPlayer.getPlayerColor());
                }
            }
        }

        //it is after round 2 and player purchased a land grant to claim more land
        //a player may install a MULE on a land he/she owns
        else if (round.currentRound > 1) {
            if (currentPlayer.hasLandGrant() && !allOwnedLands.contains(clickedButton)) {
                allOwnedLands.add(clickedButton);
                clickedButton.setStyle("-fx-border-color:" + currentPlayer.getPlayerColor() + "; -fx-background-color: transparent; -fx-border-width: 6px;");
                currentPlayer.addProperty(clickedButton);
                tile.setTileLocationColor(clickedButton.getLayoutX(), clickedButton.getLayoutY(), currentPlayer.getPlayerColor());
                currentPlayer.decrementNumLandGrants();
            }

            if (currentPlayer.getMule() != null && currentPlayer.ownsLand(clickedButton)) {
                clickedButton.setText("MULE");
                clickedButton.setStyle("-fx-border-color:" + currentPlayer.getPlayerColor() + "; -fx-background-color: transparent; -fx-border-width: 6px; -fx-text-fill: black;");
                String buttonId = clickedButton.getId();
                currentPlayer.getMule().setButtonId(buttonId);
                currentPlayer.addToOwnedMules(currentPlayer.getMule());
                currentPlayer.setMule(null);
            } else if (currentPlayer.getMule() != null && !currentPlayer.ownsLand(clickedButton)) {
                System.out.println("Player " + currentPlayer.getPlayerName().toString() + " lost a mule");
                currentPlayer.setMule(null);
            }
        }
    }

    public VBox addPlayerAttributes() {
        int i = 0;
        VBox vbox = new VBox();
        for (Player cp: players) {
            Label p = new Label("Player: " + cp.getPlayerName() + " | Score: "
                    + cp.getScore() + " | Money: " + cp.getMoney() + " | Ore: " + cp.getOre() + " | Food: " + cp.getFood()
                    + " | Energy: " + cp.getEnergy() + " | Crystite: " + cp.getCrystite());
            vbox.getChildren().add(p);
        }
        return vbox;
    }


    public void addPlayerDescriptions(TextFlow tf) {

        System.out.println("Round: " + round.getCurrentRound());
        VBox vboxx = new VBox();
        //Round round = new Round(players);
        if (round.currentRound == 0) {
            System.out.println(round.getCurrentRound());
            Label playerTurnLabel = new Label("Click on Button to Start Land Selection Phase!");
            vboxx.getChildren().add(playerTurnLabel);
        } else {
            Label playerTurnLabel = new Label("Click on Button to Continue Loaded Game!");
            vboxx.getChildren().add(playerTurnLabel);
        }

        Button nextButton = new Button();
        nextButton.setText("Next Player's Turn");
        nextButton.setOnMouseClicked(new NextButtonPressedHandler());
        nextButton.setOnMouseReleased(new TimerHandler());
        vboxx.getChildren().add(nextButton);
        vboxx.getChildren().add(addPlayerAttributes());

        tf.getChildren().add(vboxx);
    }

    private void generateScreen() throws Exception {
        Group root = new Group();



        if (ModelFacade.getInstance() != null) {
            try (BufferedReader br = new BufferedReader(new FileReader("map.text"))) {

                for (int i = 0; i < 45; i++) {
                    String line = br.readLine();
                    if (line != null){
                        String[] tokens = line.split("\t");
                        getButtons(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2]);
                    }
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ModelFacade.getInstance().getLoaded()) {
                round.currentRound = ModelFacade.getInstance().getRoundFromData();
                System.out.println("Round load: " + round.currentRound);
                if (round.currentRound > 1) {
                    landSelectionPhaseOver = true;
                }
            }
        }

        VBox vbox = new VBox(); //has another vbox with a label and a button
        addPlayerDescriptions(textflow);
        textflow.getChildren().addAll(timerLabel);
        root.getChildren().add(vbox);//root has one vbox

        anchorpane.getChildren().add(root);//has a group
    }

    private class NextButtonPressedHandler implements EventHandler<MouseEvent> {

        String labelText;


        public void nextTurn() {
            timer.setTime(31);
            if (!landSelectionPhaseOver) {
                //going to next round
                if (round.turnPhase == players.length) {
                    round.nextRound();
                    for (Player p : players) {
                        if (round.currentRound < 2) {
                            p.setHasPicked(false);
                        }
                        p.updatePlayerScore();
                    }
                    MuleUI.getInstance().getPlayerOrder(players);
                }

                //round is still happening
                if (round.turnPhase <= players.length - 1) {
                    labelText = "It is now " + players[round.turnPhase].getPlayerName() + "'s turn!";
                    updatePlayersScores(players);
                    round.turnPhase++;


                    //getting ready for next round
                } else {
                    round.turnPhase = 0;
                    labelText = "It is now " + players[round.turnPhase].getPlayerName() + "'s turn!";
                    updatePlayersScores(players);
                    round.turnPhase++;
                }

                //
                if (round.currentRound > 1) {
                    labelText = "Land Selection Phase is now over";
                    landSelectionPhaseOver = true;
                    round.turnPhase = 0;
                }
            }

            else if (round.currentRound > 1 && landSelectionPhaseOver) {

                System.out.println("out of land selection phase");
                System.out.println("TurnPhase: " + round.turnPhase);
                System.out.println("Current Round " + round.currentRound);

                //calculates order for the players
                if (round.turnPhase == players.length) {
                    round.nextRound();
                    for (Player p : players) {
                        p.setHasPicked(false);
                        p.updatePlayerScore();
                    }
                    MuleUI.getInstance().getPlayerOrder(players);
                }

                //round is still happening
                if (round.turnPhase <= players.length - 1) {
                    labelText = "It is now " + players[round.turnPhase].getPlayerName() + "'s turn!";
                    updatePlayersScores(players);
                    round.turnPhase++;

                    //getting ready for next round
                } else {
                    round.turnPhase = 0;
                    labelText = "It is now " + players[round.turnPhase].getPlayerName() + "'s turn!";
                    updatePlayersScores(players);
                    round.turnPhase++;

                    //iterate through each players owned mules and call produce
                    for (Player player: players) {

                        for (Mule mule : player.getOwnedMules()) {
                            System.out.println(mule.getButtonId());
                            if (player.getEnergy() >= player.getOwnedMules().size()) {
                                mule.produce(player);
                                player.setEnergy(player.getEnergy() - 1);
                            }

                        }
                    }
                }

                //Check to see if a random event occurs. ONLY after land selection phase
                Event.checkForRandomEvent(players, getCurrentPlayer());
            }

            TextFlow root = (TextFlow) borderpane.getChildren().get(2);
            VBox vbox2 = (VBox) root.getChildren().get(0);

            Label pLabel = (Label) vbox2.getChildren().get(0);
            pLabel.setText(labelText);
            vbox2.getChildren().remove(2);
            vbox2.getChildren().add(addPlayerAttributes());

        }


        public VBox addPlayerAttributes() {
            int i = 0;
            VBox vbox = new VBox();
            for (Player cp: players) {
                Label p = new Label("Player: " + cp.getPlayerName() + " | Score: "
                        + cp.getScore() + " | Money: " + cp.getMoney() + " | Ore: " + cp.getOre() + " | Food: " + cp.getFood()
                        + " | Energy: " + cp.getEnergy() + " | Crystite: " + cp.getCrystite());
                vbox.getChildren().add(p);
            }
            return vbox;
        }


        public void handle(MouseEvent me) {
            clickedButton = (Button) me.getSource();
            if (!(clickedButton.isDisabled())) {
                nextTurn();
            }

            if (timeRanOut) {
                timer.setTime(31);
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

            timer.setTime(timer.getTime());
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

    public void calculateTime(int roundPhase) {
        boolean hasPartialShortage = false;
        boolean hasTotalShortage = false;
        if (0 <= roundPhase && roundPhase <= 4) {
            if (0 < players[round.turnPhase].getFood() && players[round.turnPhase].getFood() < 3) {
                hasPartialShortage = true;
            } else if (players[round.turnPhase].getFood() == 0) {
                hasTotalShortage = true;
            }
        } else if (5 <= roundPhase && roundPhase <= 8) {
            if (0 < players[round.turnPhase].getFood() && players[round.turnPhase].getFood() < 4) {
                hasPartialShortage = true;
            } else if (players[round.turnPhase].getFood() == 0) {
                hasTotalShortage = true;
            }
        } else {
            if (0 < players[round.turnPhase].getFood() && players[round.turnPhase].getFood() < 5) {
                hasPartialShortage = true;
            } else if (players[round.turnPhase].getFood() == 0) {
                hasTotalShortage = true;
            }
        }

        if (hasPartialShortage) {
            timer.setTime(30);
        } else if (hasTotalShortage) {
            timer.setTime(5);
        }
    }

    @FXML
    private void handleSave(ActionEvent e) throws Exception {
        ModelFacade model = new ModelFacade();
        ModelFacade.getInstance().saveModelText();
    }





    @FXML
    public void initialize(URL url, ResourceBundle rb ) {
        try {
            generateScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Tile getTile() {
        return tile;
    }

    public void getButtons(int x, int y, String color) throws Exception {
        try{
            ObservableList<Node> buttons = gridpane.getChildren();
            System.out.println(buttons);
            for (Node node: buttons) {
                if (node.getId() != null && (node.getId().compareTo("plain") == 0
                        || node.getId().compareTo("2mountain") == 0 || node.getId().compareTo("river") == 0
                        || node.getId().compareTo("3mountain") == 0 || node.getId().compareTo("1mountain") == 0)
                        || node.getId().compareTo("swamp") == 0) {
                    Button b = (Button) node;
                    if ((int) b.getLayoutX() == x && (int) b.getLayoutY() == y) {
                        node.setStyle("-fx-border-color:" + color + "; -fx-background-color: transparent; " +
                                "-fx-border-width: 6px; -fx-text-fill: black;");
                        tile.setTileLocationColor((double) x, (double) y, color);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}