package main;

/**
 * Created by Charlie on 10/4/2015.
 */
public class Store {

    private int foodAmount;
    private int energyAmount;
    private int oreAmount;
    private int muleAmount;
    private int difficulty;

    public Store(int difficulty) {
        this.difficulty = difficulty;
        setStoreInventory(difficulty);
    }

    public void setStoreInventory(int difficulty) {
        switch (difficulty) {
            case (0): //beginner
                foodAmount = 16;
                energyAmount = 16;
                muleAmount = 25;
            default: //standard and tournament
                foodAmount = 8;
                energyAmount = 8;
                oreAmount = 8;
                muleAmount = 14;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void incrementFoodAmount() {
        foodAmount++;
    }

    public void decrementFoodAmount() {
        if (foodAmount > 0) {
            foodAmount--;
        }
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    public void incrementEnergyAmount() {
        energyAmount++;
    }

    public void decrementEnergyAmount() {
        if (energyAmount > 0) {
            energyAmount--;
        }
    }

    public int getOreAmount() {
        return oreAmount;
    }

    public void incrementOreAmount() {
        oreAmount++;
    }

    public void decrementOreAmount() {
        if (oreAmount > 0) {
            oreAmount--;
        }
    }

    public int getMuleAmount() {
        return muleAmount;
    }

    public void incrementMuleAmount() {
        muleAmount++;
    }

    public void decrementMuleAmount() {
        if (muleAmount > 0) {
            muleAmount--;
        }
    }

}

