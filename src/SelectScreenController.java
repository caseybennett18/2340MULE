 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.TextField;
 import javafx.scene.control.Button;
 import models.Player;
 import models.Race;


 
 public class SelectScreenController implements Initializable {
     
     @FXML 
     Button continueButton;

     @FXML
     TextField nameText;

     @FXML
     Button human;

     @FXML
     Button flapper;

     @FXML
     Button buzzite;

     @FXML
     Button ugaite;

     @FXML
     Button bonzoid;

     @FXML
     Button red;

     @FXML
     Button blue;

     @FXML
     Button green;

     @FXML
     Button yellow;


     private int infoRound;
     private int index;
     private Player player;

     private String name;
     private String raceId;
     private int playerColor;

     public SelectScreenController() {
         this.infoRound = MuleUI.getInstance().getnumPlayers();
         this.index = 0;
     }


     public void handleContinue() throws Exception {
         this.player = MuleUI.getInstance().getPlayer(index);
         this.setNameText();
         this.player.setRace(raceId);
         this.player.setPlayerColor(playerColor);
         System.out.println(player.getPlayerName());
         System.out.println(player.getPlayerRace());
         System.out.println(player.getPlayerID());
         System.out.println(player.getPlayerColor());
         if (infoRound != 1) {
             index++;
             infoRound--;
             this.nameText.clear();
         } else {
             MuleUI.getInstance().loadMap();
         }
     }

    @FXML
    public void setNameText() {
        this.name = nameText.getText();
        this.player.setPlayerName(this.name);
    }

     @FXML
     public void setHumanRace() {
         this.raceId = "human";
     }

     @FXML
     public void setFlapperRace() {
        this.raceId = "flapper";
     }

     @FXML
     public void setBuzziteRace() {
         this.raceId = "buzzite";
     }

     @FXML
     public void setUgaiteRace() {
         this.raceId = "ugaite";
     }

     @FXML
     public void setBonzoidRace() {
         this.raceId = "bonzoid";
     }

     @FXML
     public void setRedColor() {
         this.playerColor = 0;
         this.red.isDisabled();
     }

     @FXML
     public void setBlueColor() {
         this.playerColor = 1;
         this.blue.isDisabled();
     }

     @FXML
     public void setGreenColor() {
         this.playerColor = 2;
         this.green.isDisabled();
     }

     @FXML
     public void setYellowColor() {
         this.playerColor = 3;
         this.yellow.isDisabled();
     }
     
     public void initialize(URL url, ResourceBundle rb ) {
    }
 }