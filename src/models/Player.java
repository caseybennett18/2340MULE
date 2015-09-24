package models;

import java.util.ArrayList;
import models.races.BuzziteRace;
import models.races.UgaiteRace;
import models.races.BonzoidRace;
import models.races.HumanRace;
import models.races.FlapperRace;

/**
 * Holds a Player's information
 *
 */
public class Player {
    
    
    //private ArrayList<Resource> resources;
    //private ArrayList<Property> properties;
    private int playerColor; // 0 - Red, 1 - Blue, 2 - Green, 3 - Yellow
    private int playerID;
    private String playerName;
    protected Race race;
    private int time;
    private boolean turnPassed; 


    /**
    * @param playerID
    * constructor for player
    * sets playerID, default name and color is blank 
    */
    public Player(int playerID) {
        this.playerID = playerID;
        this.playerName = null;
        this.playerColor = 0;
        //this.race = createRace(race);
        this.time = 90;
        turnPassed = false;
 
    }
    
    /**
    * @return playerName
    */
    public String getPlayerName() {
        return playerName;
    }

    /**
    * @param name
    *           sets playerName to name
    */
    public void setPlayerName(String name) {
        playerName = name;
    }
    
    /**
    * @return playerColor
    */
    public int getPlayerColor() {
        return playerColor;
    }

    /**
    * @param color
    *           sets playerColor to color
    */
    public void setPlayerColor(int color) {
        playerColor = color;
    }
    
    /**
    * @return playerID
    */
    public int getPlayerID() {
        return playerID;
    }

    /**
    * @return race
    */
    public Race getPlayerRace() {
        return race;
    }
    
    /**
    * checks whether the player chose to pass or not
    * @return turnPassed
    */
    public boolean getTurnPassed() {
        return turnPassed;
    }
    
    /**
    * @param b
    *         set turnPassed status
    */
    public void setTurnPassed(boolean b) {
        turnPassed = b;
    }

    //0 for human, 1 for buzzite, 2 for ugaite, 3 for bonzoid, 4 for flapper
    /**
    * @param playerRace
    *         set playerRace equal to input
    */
    public void setRace(String playerRace) {
        System.out.println(playerRace);
        switch (playerRace) {
            case "human":
               race = createRace(playerRace);
            case "buzzite":
               race = createRace(playerRace);
            case "ugaite":
                race = createRace(playerRace);
            case "bonzoid":
                race = createRace(playerRace);
            case "flapper":
                race = createRace(playerRace);
            default:
                race = createRace(playerRace);
        }
    }
    
    //0 for human, 1 for buzzite, 2 for ugaite, 3 for bonzoid, 4 for flapper
    /**
    * @param playerRace
    *         
    */
    public Race createRace(String race) {
        switch (race) {
            case "human":
                return new HumanRace(playerID);
            case "buzzite":
                return new BuzziteRace(playerID);
            case "ugaite":
                 return new UgaiteRace(playerID);
            case "bonzoid":
                return new BonzoidRace(playerID);
            case "flapper":
                return new FlapperRace(playerID);
            default:
                return new HumanRace(playerID);
        }
    }

}