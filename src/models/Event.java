package models;


import models.events.*;

import java.util.Random;


/**
 * Created by Charlie on 10/26/2015.
 */

public abstract class Event {

    private int playerId;
    private Round round;
    private Player player;
    final private static double EVENT_CHANCE = .27;
    private Event[] events = {new GTAlumniEvent(playerId, round, player), new WanderingTechStudentEvent(playerId, round, player),
            new MuseumBoughtAntiqueEvent(playerId, round, player), new DeadMooseRatEvent(playerId, round, player),
            new FlyingCatBugsEvent(playerId, round, player), new UGAStudentEvent(playerId, round, player),
            new SpaceGypsyEvent(playerId, round, player)};

    final private int[] roundFactors = {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};


    public abstract boolean badEvent();
    public abstract String performEvent();


    public Event(int playerId, Round round) {
        this.playerId = playerId;
        this.round = round;
    }

    public int getRound() {
        return roundFactors[(round.getCurrentRound())];
    }

    public Event getRandomEvent() {
        Random rand = new Random();
        Event e = events[rand.nextInt(events.length)];
        return e;
    }
}
