package models;

/**
 * Created by Admin on 9/23/15.
 */
/**
 * This class classifies tiles as properties in which specific players can own them.
 */
public class Property {
    private int playerID;
    private Tile tile;

    public Property(Tile tile) {
        this.playerID = -1;
        this.tile = tile;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int newID) {
        playerID = newID;
    }

    public Tile getTile() {
        return tile;
    }
}
