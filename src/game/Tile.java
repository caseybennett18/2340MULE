package game;

/**
 * This class defines a Tile which resides on the Map.
 * A Tile has a TileType, a x location (row), and a y location (column).
 * It also has a boolean flag, selected, to signify whether it is currently selected or not.
 */
public class Tile {
    private TileType tileType;
    private int xLocation, yLocation;
    private boolean selected;
    private Property property;

    public Tile(TileType tileType, int x, int y) {
        this.tileType = tileType;
        xLocation = x;
        yLocation = y;
        selected = false;
        property = new Property(this);
    }

    public TileType getTileType() {
        return tileType;
    }

    public int getXLocation() {
        return xLocation;
    }

    public int getYLocation() {
        return yLocation;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean a) {
        selected = a;
    }

    public Property getProperty() {
        return property;
    }
}
