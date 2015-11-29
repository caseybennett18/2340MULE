package main.models;

/**
 * Created by Admin on 9/23/15.
 */
public enum TileType {
    RIVER(4,2,0, "src/res/River.png"),
    PLAIN(2,3,1, "src/res/grass.png"),
    MOUNTAIN_1(1,1,2, "src/res/Mountain_1.png"),
    MOUNTAIN_2(1,1,3, "src/res/Mountain_2.png"),
    MOUNTAIN_3(1,1,4, "src/res/Mountain_3.png"),
    TOWN(0,0,0, "src/res/town.png");

    private int food;
    private int energy;
    private int ore;
    private String imagePath;

    TileType(int food, int energy, int ore, String imagePath) {
        this.food = food;
        this.energy = energy;
        this.ore = ore;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return imagePath;
    }
}
