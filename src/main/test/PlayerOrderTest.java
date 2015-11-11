package main.test;

import main.MuleUI;
import data.Player;
import driver.GameController;
import java.util.ArrayList;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by Chelsea on 11/10/15.
 * Test Method for the getPlayerOrder method
 */
public class PlayerOrderTest {

    /**
     * Creates a list of players for the game instance
     * @return list of players to initiate game controller
     */
    public ArrayList<Player> createPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player1 = new Player(0, "Player 1", 0, "Buzzite");
        Player player2 = new Player(1, "Player 2", 1, "Ugaite");
        Player player3 = new Player(2, "Player 3", 2, "Packer");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        return players;
    }

    /**
     * Tests the player order by making sure that the
     * highest scoring player goes first and so on
     */
    @Test
    public void testGetPlayerOrder() throws Exception {
        ArrayList<Player> players = createPlayers();
        GameController gc = new GameController(0, players, 0);
        gc.beginGame();

        players = gc.getPlayers();
        players.get(0).changeMoneyBy(20000); //Should set score to 21000
        players.get(1).changeMoneyBy(10000); //Should set score to 11000
        players.get(2).changeMoneyBy(30000); //Should set score to 31000

        gc.getRound().calculatePlayerOrder();
        LinkedList<Player> order = gc.getRound().getPlayerOrder();
        System.out.println(order.get(0).getScore());
        System.out.println(order.get(1).getScore());
        System.out.println(order.get(2).getScore());
        LinkedList<Player> testOrder = new LinkedList<Player>();

        //Player order should be determined by allowing
        //the highest scoring player to go first and so on
        testOrder.add(players.get(2));
        testOrder.add(players.get(0));
        testOrder.add(players.get(1));


        assertEquals(testOrder, order);
    }
}