package main.test;

import main.MuleUI;
import main.StartScreenController;
import main.models.Mule;
import main.models.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by caseybennett on 11/10/15.
 *
 * Test Method for StartScreenController by Casey Bennett
 */
public class StartScreenControllerTest {


    @Test
    public void testCreatePlayers() throws Exception {
        //Test creation of one player
        StartScreenController controller = new StartScreenController();
        MuleUI main = new MuleUI();
        controller.numPlayersOne();
        controller.setBeginnerButton();
        controller.createPlayers();
        assertSame(controller.getNumPlayers(), 1);
        assertSame(controller.getDifficulty(), 0);
        Player p = main.getInstance().getPlayer(0);
        assertSame(p.getFood(), 8);
        assertSame(p.getEnergy(), 4);
        assertSame(p.getOre(), 0);

        //Test creation of multiple players
        StartScreenController controller2 = new StartScreenController();
        MuleUI main2 = new MuleUI();
        controller2.numPlayersFour();
        controller2.setTournamentButton();
        main2.setnumPlayers(4);
        controller2.createPlayers();
        assertSame(controller2.getNumPlayers(), 4);
        assertSame(controller2.getDifficulty(), 2);
        assertNotNull(main2.getInstance().getPlayer(0));
        assertNotNull(main2.getInstance().getPlayer(1));
        assertNotNull(main2.getInstance().getPlayer(2));
        assertNotNull(main2.getInstance().getPlayer(3));

    }
}