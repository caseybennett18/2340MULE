package main.models;

import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.control.Button;
import main.models.races.*;

/**
 * Holds a Player's information
 *
 */
public class Player {
    
    
    //private ArrayList<Resource> resources;
    //private ArrayList<Property> properties;
    public int playerColor; // 0 - Red, 1 - Blue, 2 - Green, 3 - Yellow
    private final int playerID;
    private String playerName;
    public Race race;

    private int food;
    private int energy;
    private int ore;
    private int money;
    private Mule mule;
    private int crystite;

    private int score;

    //temporary fix
    private int numLandGrants;
    private final ArrayList<Button> ownedLand;
    private boolean hasPicked;

    private ArrayList<Mule> ownedMules;

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
        int time = 50;
        boolean turnPassed = false;
        numLandGrants = 0;
        ownedLand = new ArrayList<>();
        ownedMules = new ArrayList<>();
    }

    //cost of food = cost of energy = cost of ore = $100
    public void updatePlayerScore() {

        score = money + (getNumProperties() * 500) + ((food + energy + ore + crystite) * 100);
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



    public String getPlayerColor(int color) {
        if (color == 0) {
            return "#FF0000";
        } else if (color == 1) {
            return "#0000FF";
        } else if (color == 2) {
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
        switch (color) {
            case "#FF0000":
                playerColor = 0;
                break;
            case "#0000FF":
                playerColor = 1;
                break;
            case "#00FF00":
                playerColor = 2;
                break;
            default:
                playerColor = 3;
                break;
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
    
// --Commented out by Inspection START (11/5/2015 8:35 PM):
//    /**
//    * checks whether the player chose to pass or not
//    * @return turnPassed
//    */
//    public boolean getTurnPassed() {
//        return turnPassed;
//    }
// --Commented out by Inspection STOP (11/5/2015 8:35 PM)

// --Commented out by Inspection START (11/5/2015 8:35 PM):
//    /**
//    * @param b
//    *         set turnPassed status
//    */
//    public void setTurnPassed(boolean b) {
//        turnPassed = b;
//    }
// --Commented out by Inspection STOP (11/5/2015 8:35 PM)

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
            case "mechtron":
                race = createRace(playerRace);
            case "leggite":
                race = createRace(playerRace);
            case "gollumer":
                race = createRace(playerRace);
            case "packer":
                race = createRace(playerRace);
            default:
                race = createRace(playerRace);
        }
    }
    
    //0 for human, 1 for buzzite, 2 for ugaite, 3 for bonzoid, 4 for flapper
    /**
    * @param String race
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
            case "mechtron":
                return new MechtronRace(playerID);
            case "leggite":
                return new LeggiteRace(playerID);
            case "gollumer":
                return new GollumerRace(playerID);
            case "packer":
                return new PackerRace(playerID);
            default:
                return new HumanRace(playerID);
        }
    }

// --Commented out by Inspection START (11/5/2015 8:35 PM):
//    public void setOwnedMules(ArrayList<Mule> mules) {
//        ownedMules = mules;
//    }
// --Commented out by Inspection STOP (11/5/2015 8:35 PM)

    public ArrayList<Mule> getOwnedMules() {
        return ownedMules;
    }

    public void addToOwnedMules(Mule mule) {
        ownedMules.add(mule);
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

    private int getNumProperties() {
        return ownedLand.size();
    }

    public int getNumLandGrants() {
        return numLandGrants;
    }

    public void incrementNumLandGrants() {
        numLandGrants++;
    }

    public void decrementNumLandGrants() {
        numLandGrants--;
    }

    public boolean hasLandGrant() {
        return numLandGrants > 0;
    }

    private ArrayList<Button> getOwnedLand() {
        return ownedLand;
    }

    public void addProperty(Button b) {
        ownedLand.add(b);
    }

// --Commented out by Inspection START (11/5/2015 8:35 PM):
//    public void removeProperty(Button b) {
//        ownedLand.remove(b);
//    }
// --Commented out by Inspection STOP (11/5/2015 8:35 PM)

    public boolean ownsLand(Button b) {
        return ownedLand.contains(b);
    }

    public boolean hasPicked() {
        return hasPicked;
    }

    public void setHasPicked(boolean b) {
        hasPicked = b;
    }

    public int getCrystite() {
        return crystite;
    }

    public void setCrystite(int numCrystite) {
        crystite = numCrystite;
    }



    public void saveTo(PrintWriter out) {
        out.println(playerName + "\t" + playerColor + "\t" + playerID + "\t" + race + "\t" + food + "\t" + energy + "\t" + money + "\t" + ore + "\t" + score + "\t" + getOwnedLand() + "\t" + ownedMules.toString());
    }
}