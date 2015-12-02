package main.models;


import main.controllers.MapScreenController;
import main.models.events.*;

import java.util.Random;


/**
 * Created by Charlie on 10/26/2015.
 */

public abstract class Event {

    //private int playerId;
    //private Round round;
    //private Player player;
    //final private static double EVENT_CHANCE = .27;
    private static Event[] events = {new GTAlumniEvent(), new WanderingTechStudentEvent(),
            new MuseumBoughtAntiqueEvent(), new DeadMooseRatEvent(),
            new FlyingCatBugsEvent(), new UGAStudentEvent(),
            new SpaceGypsyEvent(), new HomeWorldCharity(), new MischievousGlacElves(),
            new MuleCleaningCost(), new SwampEelEatingContest()};

    final private int[] roundFactors = {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};


    public abstract boolean badEvent();
    public abstract String performEvent();


    //public Event(Player p, int playerId, Round round) {
    //    this.player = p;
    //    this.playerId = playerId;
    //    this.round = round;
    //}

    public int getRound() {
        return roundFactors[MapScreenController.getInstance().getCurrentRound().getCurrentRound()];
    }

    public static Event getRandomEvent() {
        Random rand = new Random();
        return events[rand.nextInt(events.length)];
    }

    public static String checkForRandomEvent(Player[] players, Player p) {
        Event e = null;
        boolean eventOccurred = false;
        Random random = new Random();
        int randomChance = random.nextInt(99);

        //27% chance for a random event to occur
        if (randomChance <= 26) {
            eventOccurred = true;
            e = getRandomEvent();

            //bad event cannot happen to player with lowest score (i.e. player first to go)
            while (p == players[0] && e.badEvent()) {
                e = getRandomEvent();
            }
        }

        if (eventOccurred) {
            String s = e.performEvent();
            System.out.println(s);
            return s;
        } else {
            return null;
        }
    }
}