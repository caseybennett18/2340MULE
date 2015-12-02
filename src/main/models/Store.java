package main.models;

/**
 * Created by Charlie on 10/4/2015.
 * Store Class determines food, energy, ore, and mule amount based on the difficulty of the game.
 */
public class Store {

    private int foodAmount;
    private int energyAmount;
    private int oreAmount;
    private int muleAmount;

    public Store(int difficulty) {
        int difficulty1 = difficulty;
        setStoreInventory(difficulty);
    }

    /**
     * setStoreInventory Method: set's inventory based on game difficulty.
     * Param: int difficulty
     * Return Type: void
     */
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

    /**
     * getFoodAmount Method: getter for food amount.
     * Param: none
     * Return Type: int
     */
    public int getFoodAmount() {
        return foodAmount;
    }

    /**
     * incrementFoodAmount Method: increments the food amount.
     * Param: none
     * Return Type: void
     */
    public void incrementFoodAmount() {
        foodAmount++;
    }

    /**
     * decrementFoodAmount Method: decrements the food amount.
     * Param: none
     * Return Type: void
     */
    public void decrementFoodAmount() {
        if (foodAmount > 0) {
            foodAmount--;
        }
    }

    /**
     * getEnergyAmount Method: getter for energy.
     * Param: none
     * Return Type: void
     */
    public int getEnergyAmount() {
        return energyAmount;
    }

    /**
     * getEnergyAmount Method: increment energy amount.
     * Param: none
     * Return Type: void
     */
    public void incrementEnergyAmount() {
        energyAmount++;
    }

    /**
     * getEnergyAmount Method: decrement energy amount, as long as there is energy.
     * Param: none
     * Return Type: void
     */
    public void decrementEnergyAmount() {
        if (energyAmount > 0) {
            energyAmount--;
        }
    }

    /**
     * getOreAmount Method: getter for ore.
     * Param: none
     * Return Type: void
     */
    public int getOreAmount() {
        return oreAmount;
    }

    /**
     * getOreAmount Method: increment ore amount.
     * Param: none
     * Return Type: void
     */
    public void incrementOreAmount() {
        oreAmount++;
    }

    /**
     * getOreAmount Method: decrement ore amount as long as there is ore.
     * Param: none
     * Return Type: void
     */
    public void decrementOreAmount() {
        if (oreAmount > 0) {
            oreAmount--;
        }
    }

    /**
     * getMuleAmount Method: getter for mule amounts.
     * Param: none
     * Return Type: void
     */
    public int getMuleAmount() {
        return muleAmount;
    }

    /**
     * getMuleAmount Method: increment the amount of mules.
     * Param: none
     * Return Type: void
     */
    public void incrementMuleAmount() {
        muleAmount++;
    }

    /**
     * getMuleAmount Method: decrement Mule Amount as long as there are more than zero.
     * Param: none
     * Return Type: void
     */
    public void decrementMuleAmount() {
        if (muleAmount > 0) {
            muleAmount--;
        }
    }

}