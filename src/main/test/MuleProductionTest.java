package main.test;

import main.models.Player;
import main.models.mules.EnergyMule;
import main.models.mules.FoodMule;
import main.models.mules.OreMule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class MuleProductionTest {
    protected Player p;

    @Before
    public void setup() {
        p = new Player(1);
    }

    @Test
    public void testEnergyMule() throws Exception {
        EnergyMule plainMule = new EnergyMule(p.getPlayerID(), "plain", p);
        EnergyMule oneMountainMule = new EnergyMule(p.getPlayerID(), "1mountain", p);
        EnergyMule twoMountainMule = new EnergyMule(p.getPlayerID(), "2mountain", p);
        EnergyMule threeMountainMule = new EnergyMule(p.getPlayerID(), "3mountain", p);
        EnergyMule riverMule = new EnergyMule(p.getPlayerID(), "river", p);
        EnergyMule invalidMule = new EnergyMule(p.getPlayerID(), "invalid", p);

        //make sure player energy starts out as 0
        assertSame(0, p.getEnergy());

        //test plain Mule
        plainMule.produce(p);
        //player energy should be 3 (+3)
        assertSame(3, p.getEnergy());

        //test one mountain Mule
        oneMountainMule.produce(p);
        //player energy should be 4 (+1)
        assertSame(4, p.getEnergy());

        //test two mountain Mule
        twoMountainMule.produce(p);
        //player energy should be 5 (+1)
        assertSame(5, p.getEnergy());

        //test three mountain Mule
        threeMountainMule.produce(p);
        //player energy should be 6 (+1)
        assertSame(6, p.getEnergy());

        //test river Mule
        riverMule.produce(p);
        //player energy should be 8 (+2)
        assertSame(8, p.getEnergy());

        //test default/invalid Mule
        invalidMule.produce(p);
        //player energy should be 8 (+0)
        assertSame(8, p.getEnergy());
    }

    @Test
    public void testFoodMule() throws Exception {
        FoodMule plainMule = new FoodMule(p.getPlayerID(), "plain", p);
        FoodMule oneMountainMule = new FoodMule(p.getPlayerID(), "1mountain", p);
        FoodMule twoMountainMule = new FoodMule(p.getPlayerID(), "2mountain", p);
        FoodMule threeMountainMule = new FoodMule(p.getPlayerID(), "3mountain", p);
        FoodMule riverMule = new FoodMule(p.getPlayerID(), "river", p);
        FoodMule invalidMule = new FoodMule(p.getPlayerID(), "invalid", p);

        //make sure player food starts out as 0
        assertSame(0, p.getFood());

        //test plain Mule
        plainMule.produce(p);
        //player food should be 2 (+2)
        assertSame(2, p.getFood());

        //test one mountain Mule
        oneMountainMule.produce(p);
        //player food should be 3 (+1)
        assertSame(3, p.getFood());

        //test two mountain Mule
        twoMountainMule.produce(p);
        //player food should be 4 (+1)
        assertSame(4, p.getFood());

        //test three mountain Mule
        threeMountainMule.produce(p);
        //player food should be 5 (+1)
        assertSame(5, p.getFood());

        //test river Mule
        riverMule.produce(p);
        //player food should be 9 (+4)
        assertSame(9, p.getFood());

        //test default/invalid Mule
        invalidMule.produce(p);
        //player food should be 9 (+0)
        assertSame(9, p.getFood());
    }

    @Test
    public void testOreMule() throws Exception {
        OreMule plainMule = new OreMule(p.getPlayerID(), "plain", p);
        OreMule oneMountainMule = new OreMule(p.getPlayerID(), "1mountain", p);
        OreMule twoMountainMule = new OreMule(p.getPlayerID(), "2mountain", p);
        OreMule threeMountainMule = new OreMule(p.getPlayerID(), "3mountain", p);
        OreMule riverMule = new OreMule(p.getPlayerID(), "river", p);
        OreMule invalidMule = new OreMule(p.getPlayerID(), "invalid", p);

        //make sure player ore starts out as 0
        assertSame(0, p.getOre());

        //test plain Mule
        plainMule.produce(p);
        //player ore should be 1 (+1)
        assertSame(1, p.getOre());

        //test one mountain Mule
        oneMountainMule.produce(p);
        //player ore should be 3 (+2)
        assertSame(3, p.getOre());

        //test two mountain Mule
        twoMountainMule.produce(p);
        //player ore should be 6 (+3)
        assertSame(6, p.getOre());

        //test three mountain Mule
        threeMountainMule.produce(p);
        //player ore should be 10 (+4)
        assertSame(10, p.getOre());

        //test river Mule
        riverMule.produce(p);
        //player ore should be 10 (+0)
        assertSame(10, p.getOre());

        //test default/invalid Mule
        invalidMule.produce(p);
        //player ore should be 10 (+0)
        assertSame(10, p.getOre());
    }
}
