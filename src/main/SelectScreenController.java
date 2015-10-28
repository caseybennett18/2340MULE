package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import main.models.Player;


/**
 * Controller for SelectScreenController view
 * 
 */
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
 	private String playerColor;

 	/**
	 * constructor for SelectScreenController
	 *
	 */
 	public SelectScreenController() {
 		this.infoRound = MuleUI.getInstance().getnumPlayers();
 		this.index = 0;
 	}

 	/**
	 * 
	 *@throws Exception
	 *				sets the name, race, color, and money for subsequent players
	 */
 	public void handleContinue() throws Exception {
 		this.player = MuleUI.getInstance().getPlayer(index);
 		this.setNameText();
 		this.player.setRace(raceId);
 		this.player.setPlayerColor(playerColor);
		player.setMoney(player.getPlayerRace().getMoney());

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

 	/**
    * setPlayerName is set to nameText
    */
 	@FXML
 	public void setNameText() {
 		this.name = nameText.getText();
 		this.player.setPlayerName(this.name);
 	}

 	/**
    * raceId is set to human
    */
 	@FXML
 	public void setHumanRace() {
 		this.raceId = "human";
 	}

 	/**
    * raceId is set to flapper
    */
 	@FXML
 	public void setFlapperRace() {
 		this.raceId = "flapper";
 	}

 	/**
    * raceId is set to buzzite
    */
 	@FXML
 	public void setBuzziteRace() {
 		this.raceId = "buzzite";
 	}

 	/**
    * raceId is set to ugaite
    */
 	@FXML
 	public void setUgaiteRace() {
 		this.raceId = "ugaite";
 	}

 	/**
    * raceId is set to bonzoid
    */
 	@FXML
 	public void setBonzoidRace() {
 		this.raceId = "bonzoid";
 	}

 	/**
    * playerColor is set to red
    */
 	@FXML
 	public void setRedColor() {
 		this.playerColor = "#FF0000";
 		this.red.isDisabled();
 	}

 	/**
    * playerColor is set to blue
    */
 	@FXML
 	public void setBlueColor() {
 		this.playerColor = "#0000FF";
 		this.blue.isDisabled();
 	}

 	/**
    * playerColor is set to green
    */
 	@FXML
 	public void setGreenColor() {
 		this.playerColor = "#00FF00";
 		this.green.isDisabled();
 	}

 	/**
    * playerColor is set to yellow
    */
 	@FXML
 	public void setYellowColor() {
 		this.playerColor = "#FFFF00";
 		this.yellow.isDisabled();
 	}

 	/**
	 * @param url, rb
	 *            
	 */
 	public void initialize(URL url, ResourceBundle rb ) {
 	}
 }