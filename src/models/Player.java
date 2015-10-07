package models;

import java.util.ArrayList;

import javafx.scene.control.Button;
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

    private int food;
    private int energy;
    private int ore;
    private int money;
    private Mule mule;

    private int score;

    //temporary fix
    private int numProperties;
    private ArrayList<Button> ownedLand;
    private boolean hasPicked;

    //private ArrayList<Integer> resources;   // 0-money 1-food 2-energy 3-Smithore 4-Crystite


    /**
    * @param playerID
    * constructor for player
    * sets playerID, default name and color is blank 
    */
    public Player(int playerID) {
        this.playerID = playerID;
        this.playerName = null;
        this.mule = null;
        this.playerColor = 0;
        this.time = 50;
        turnPassed = false;
        numProperties = 0;
        ownedLand = new ArrayList<>();
    }

    //cost of food = cost of energy = cost of ore = $100
    public void updatePlayerScore() {
        score = money + (numProperties * 500) + ((food + energy + ore) * 100);
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
    public String getPlayerColor() {
        if (playerColor == 0) {
            return "#FF0000";
        } else if (playerColor == 1) {
            return "#0000FF";
        } else if (playerColor == 2) {
            return "#00FF00";
        } else {
            return "#FFFF00";
        }
    }

    /**
    * @param color
    *           sets playerColor to color
    */
    public void setPlayerColor(String color) {
        if (color == "#FF0000") {
            playerColor = 0;
        } else if (color == "#0000FF") {
            playerColor = 1;
        } else if (color == "#00FF00") {
            playerColor = 2;
        } else {
            playerColor = 3;
        }
    }

    public Mule getMule() {
        return mule;
    }

    public void setMule(Mule m) {
        mule = m;
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
    * @param
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

    public int getFood() {
        return food;
    }

    public void setFood(int f) {
        this.food = f;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int e) {
        this.energy = e;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int o) {
        this.ore = o;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int amount) {
        money = amount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumProperties() {
        return numProperties;
    }

    public void incrementNumProperties() {
        numProperties++;
    }

    public ArrayList<Button> getOwnedLand() {
        return ownedLand;
    }

    public void addProperty(Button b) {
        ownedLand.add(b);
    }

    public void removeProperty(Button b) {
        ownedLand.remove(b);
    }

    public boolean ownsLand(Button b) {
        return ownedLand.contains(b);
    }

    public boolean hasPicked() {
        return hasPicked;
    }

    public void setHasPicked(boolean b) {
        hasPicked = b;
    }
}