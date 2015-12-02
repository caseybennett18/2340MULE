package main.test;

import main.models.Player;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Charlie on 11/12/2015.
 */

public class CharlieJUnitTest {

    @Test
    public void testColorSelection() throws Exception {
        //SelectScreenController controller = new SelectScreenController();
        //MuleUI mainMule = new MuleUI();
        Player player = new Player(0);
        player.setPlayerColor("#FF0000");
        assertSame(player.playerColor, 0);
        player.setPlayerColor("#00FF00");
        assertSame(player.playerColor, 2);
        player.setPlayerColor("#0000FF");
        assertSame(player.playerColor, 1);
        player.setPlayerColor("#FFFF00");
        assertSame(player.playerColor, 3);

    }
}
