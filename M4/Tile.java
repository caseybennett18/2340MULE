public class Tile {
    
    int food;
    int energy;
    int ore;
    int crystite;
    Mule mule;
    
    public Tile(int food, int energy,
        int ore, int crystite, Mule mule) {
        this.food = food;
        this.energy = energy;
        this.ore = ore;
        this.crystite = crystite;
        this.mule = mule;
 
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
    
    public int getCrystite() {
        return crystite;
    }
    
    public boolean muleStatus() {
        if (mule != null) {
            return mule;
        } else {
            return null;
        }
    }
}