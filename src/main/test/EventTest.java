package main.test;

import main.models.Event;
import main.models.Player;
import main.models.events.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by caseybennett on 12/3/15.
 */
public class EventTest {


    private Event[] events = {new GTAlumniEvent(), new WanderingTechStudentEvent(),
            new MuseumBoughtAntiqueEvent(), new DeadMooseRatEvent(),
            new FlyingCatBugsEvent(), new UGAStudentEvent(),
            new SpaceGypsyEvent(), new HomeWorldCharity(), new MischievousGlacElves(),
            new MuleCleaningCost(), new SwampEelEatingContest()};
    private Event testerEvent;

    @Before
    public void setUp() throws Exception {
        testerEvent = new Event() {
            @Override
            public boolean badEvent() {
                return false;
            }

            @Override
            public String performEvent() {
                return null;
            }
        };
    }

    @Test
    public void testGetRandomEvent() throws Exception {
        Event testEvent = testerEvent.getRandomEvent();

        assertNotNull(testEvent);
        assertFalse(testEvent.badEvent());

        Event testEvent2 = testerEvent.getRandomEvent();

        assertNotNull(testEvent2);
        assertFalse(testEvent2.badEvent());

    }

    @Test (expected = java.lang.NullPointerException.class)
    public void testCheckForRandomEvent() throws Exception {
        Player[] players = {new Player(1), new Player(2), new Player(3)};

        String result = testerEvent.checkForRandomEvent(players, players[0]);
        assertNull(result);

        String result2 = testerEvent.checkForRandomEvent(players, players[1]);
        assertNull(result2);

        String result3 = testerEvent.checkForRandomEvent(players, players[2]);
        assertNull(result3);
    }
}