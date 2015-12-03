package main.test;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import main.models.Player;
import main.models.Race;
import main.models.mules.OreMule;
import main.models.races.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by caseybennett on 12/3/15.
 */
public class PlayerTest {

    private Player testPlayer;

    @Before
    public void setUp() {
        //create a new player
        testPlayer = new Player(1);
//        Button b = new Button();
//        testPlayer.addProperty(b);

    }

    @Test
    public void testUpdatePlayerScore() throws Exception {
        //player has one property
        //set money, food, ore, mules, crystite, money
        testPlayer.setMoney(100);
        testPlayer.setFood(5);
        testPlayer.setCrystite(5);
        testPlayer.setOre(5);

        testPlayer.updatePlayerScore();

        assertNotNull(testPlayer.getScore());
        assertEquals(1600, testPlayer.getScore());
    }

    @Test
    public void testGetPlayerColor() throws Exception {

        //0 should return #ff0000
        String color = testPlayer.getPlayerColor(0);
        assertNotNull(color);
        assertEquals("#FF0000", color);

        //1 should return #0000ff
        String color2 = testPlayer.getPlayerColor(1);
        assertNotNull(color2);
        assertEquals("#0000FF", color2);

        //2 should return #00FF00
        String color3 = testPlayer.getPlayerColor(2);
        assertNotNull(color3);
        assertEquals("#00FF00", color3);

        //3 should return #FFFF00
        String color4 = testPlayer.getPlayerColor(3);
        assertNotNull(color4);
        assertEquals("#FFFF00", color4);

    }


    @Test
    public void testCreateRace() throws Exception {
        //case human
        HumanRace humanRace = new HumanRace(1);
        Race result1 = testPlayer.createRace("human");
        assertNotNull(result1);
        assertSame(humanRace.toString(), result1.toString());

        //case buzzite
        BuzziteRace buzziteRace = new BuzziteRace(1);
        Race result2 = testPlayer.createRace("buzzite");
        assertNotNull(result2);
        assertSame(buzziteRace.toString(), result2.toString());

        //case ugaite
        UgaiteRace ugaiteRace = new UgaiteRace(1);
        Race result3 = testPlayer.createRace("ugaite");
        assertNotNull(result3);
        assertSame(ugaiteRace.toString(), result3.toString());

        //case bonzoid
        BonzoidRace bonzoidRace = new BonzoidRace(1);
        Race result4 = testPlayer.createRace("bonzoid");
        assertNotNull(result4);
        assertSame(bonzoidRace.toString(), result4.toString());

        //case flapper
        FlapperRace flapperRace = new FlapperRace(1);
        Race result5 = testPlayer.createRace("flapper");
        assertNotNull(result5);
        assertSame(flapperRace.toString(), result5.toString());

        //case mechtron
        MechtronRace mechtronRace = new MechtronRace(1);
        Race result6 = testPlayer.createRace("mechtron");
        assertNotNull(result6);
        assertSame(mechtronRace.toString(), result6.toString());

        //case leggite
        LeggiteRace leggiteRace = new LeggiteRace(1);
        Race result7 = testPlayer.createRace("leggite");
        assertNotNull(result7);
        assertSame(leggiteRace.toString(), result7.toString());

        //case gollumer
        GollumerRace gollumerRace = new GollumerRace(1);
        Race result8 = testPlayer.createRace("gollumer");
        assertNotNull(result8);
        assertSame(gollumerRace.toString(), result8.toString());

        //case packer
        PackerRace packerRace = new PackerRace(1);
        Race result9 = testPlayer.createRace("packer");
        assertNotNull(result9);
        assertSame(packerRace.toString(), result9.toString());
    }
}