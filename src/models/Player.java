package models;

import java.util.ArrayList;
import models.races.BuzziteRace;
import models.races.UgaiteRace;
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



    public Player(int playerID) {
        this.playerID = playerID;
        this.playerName = null;
        this.playerColor = 0;
        //this.race = createRace(race);
        this.time = 90;
        turnPassed = false;
 
    }
    
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        playerName = name;
    }
    
    public int getPlayerColor() {
        return playerColor;
    }


    public void setPlayerColor(int color) {
        playerColor = color;
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