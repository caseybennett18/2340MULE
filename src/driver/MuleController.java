package driver;

import java.util.ArrayList;

import game.*;
import models.*;

public class GameController {
    private int difficulty;
    private ArrayList<Player> players;
    private Map map;
    
    private static GameController instance;

    public GameController(int difficulty, ArrayList<Player> players) {
        instance = this;
        this.difficulty = difficulty;
        this.players = players;
        map = new Map();
    }

    public void setPlayer(int index, String name, int chosenColor, String chosenRace) {
        players.add(index, new Player(index, name, chosenColor, chosenRace));
    }

    public static GameController getInstance() {
        return instance;
    }

    public Map getMap() {
        return map;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
