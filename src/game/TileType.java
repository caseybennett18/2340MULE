package game;

/**
 * This class is an enum that has all of the possible land types for each tile.
 */
public enum TileType {
    RIVER(4,2,0),
    PLAIN(2,3,1),
    MOUNTAIN_1(1,1,2),
    MOUNTAIN_2(1,1,3),
    MOUNTAIN_3(1,1,4),
    TOWN(0,0,0);

    private int food;
    private int energy;
    private int ore;

    private TileType(int food, int energy, int ore) {
        this.food = food;
        this.energy = energy;
        this.ore = ore;
    }

    public int getFood() {
        return food;
    }

    public int getEnergy() {
        return energy;
    }

    public int getOre() {
        return ore;
    }
}
