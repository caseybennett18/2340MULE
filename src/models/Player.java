package models;

import java.util.ArrayList;
import models.races.BuzziteRace;
//import models.races.UgaiteRace;
import models.races.BonzoidRace;
import models.races.HumanRace;
import models.races.FlapperRace;
/**
 * Created by Admin on 9/22/15.
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



    public Player(int playerID, String playerName, int playerColor, String race) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.playerColor = playerColor;
        this.race = createRace(race);
        this.time = 90;
        turnPassed = false;
 
    }
    
    public String getPlayerName() {
        return playerName;
    }
    
    public int getPlayerColor() {
        return playerColor;
    }
    
    public int getPlayerID() {
        return playerID;
    }
    
    public Race getPlayerRace() {
        return race;
    }
    
    public boolean getTurnPassed() {
        return turnPassed;
    }
    
    public void setTurnPassed(boolean b) {
        turnPassed = b;
    }
    
    protected Race createRace(String race) {
        switch (race) {
            case "Human":
                return new HumanRace(playerID);
            case "Buzzite":
                return new BuzziteRace(playerID);
            case "Ugaite":
                //return new UgaiteRace(playerID);
            case "Bonzoid":
                return new BonzoidRace(playerID);
            default:
                return new FlapperRace(playerID);
        }
    }

}