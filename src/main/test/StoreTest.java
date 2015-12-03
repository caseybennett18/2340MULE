package main.test;

import main.models.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by caseybennett on 12/3/15.
 */
public class StoreTest {


    private Store testStore;

    @Before
    public void setUp() {
        testStore = new Store(0);
    }

    @Test
    public void testSetStoreInventory() throws Exception {

        //beginner difficulty store inventory
        testStore.setStoreInventory(0);
        assertNotNull(testStore.getFoodAmount());
        assertNotEquals(16, testStore.getFoodAmount());
        assertNotEquals(16, testStore.getEnergyAmount());
        assertNotEquals(25, testStore.getMuleAmount());

        //other difficulty store inventory
        testStore.setStoreInventory(1);
        assertNotNull(testStore.getFoodAmount());
        assertEquals(8, testStore.getFoodAmount());
        assertEquals(8, testStore.getEnergyAmount());
        assertEquals(14, testStore.getMuleAmount());
    }

    @Test
    public void testDecrementFoodAmount() throws Exception {
        //check to make sure it doesn't decrement into negative numbers
        testStore.decrementFoodAmount();
        testStore.decrementFoodAmount();
        testStore.decrementFoodAmount();
        testStore.decrementFoodAmount();
        testStore.decrementFoodAmount();
        testStore.decrementFoodAmount();
        testStore.decrementFoodAmount();
        testStore.decrementFoodAmount();
        testStore.decrementFoodAmount();
        testStore.decrementFoodAmount();
        assertNotNull(testStore.getFoodAmount());
        assertEquals(0, testStore.getFoodAmount());

        //check to make sure that it decrements properly
        testStore.setStoreInventory(0);
        testStore.decrementFoodAmount();
        assertNotNull(testStore.getFoodAmount());
        assertEquals(7, testStore.getFoodAmount());
    }

    @Test
    public void testDecrementEnergyAmount() throws Exception {
        //check to make sure it doesn't decrement into negative numbers
        testStore.decrementEnergyAmount();
        testStore.decrementEnergyAmount();
        testStore.decrementEnergyAmount();
        testStore.decrementEnergyAmount();
        testStore.decrementEnergyAmount();
        testStore.decrementEnergyAmount();
        testStore.decrementEnergyAmount();
        testStore.decrementEnergyAmount();
        testStore.decrementEnergyAmount();
        testStore.decrementEnergyAmount();
        assertNotNull(testStore.getEnergyAmount());
        assertEquals(0, testStore.getEnergyAmount());

        //check to make sure it decrements properly
        testStore.setStoreInventory(0);
        testStore.decrementEnergyAmount();
        assertNotNull(testStore.getEnergyAmount());
        assertEquals(7, testStore.getEnergyAmount());
    }
}