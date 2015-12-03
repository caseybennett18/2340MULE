package main.test;

import static org.junit.Assert.*;

import main.models.Gamble;

import static org.junit.Assert.*;

/**
 * Created by caseybennett on 12/3/15.
 */
public class GambleTest {
    @org.junit.Test
    public void testCalculateBonus() throws Exception {
        Gamble gamble = new Gamble();

        int answer = gamble.calculateBonus(4, 10); //first number: timebonus, second number, roundbonus
        assertNotNull(answer);
        assertEquals(150, gamble.roundBonus); //roundBonus
        assertEquals(50, gamble.timeBonus); //timeBonus

        Gamble gamble2 = new Gamble();
        int answer2 = gamble2.calculateBonus(8,14); //first num: time bonus, second: roundBonus.
        assertNotNull(answer2);
        assertEquals(200, gamble2.roundBonus);
        assertEquals(50, gamble2.timeBonus);

        Gamble gamble3 = new Gamble();
        int answer3 = gamble3.calculateBonus(14,14);
        assertNotNull(answer3);
        assertEquals(200, gamble3.roundBonus);
        assertEquals(100, gamble3.timeBonus);

        Gamble gamble4 = new Gamble();
        int answer4 = gamble4.calculateBonus(26,10); //first number refers to second assertequals
        assertNotNull(answer4);
        assertEquals(150, gamble4.roundBonus);
        assertEquals(150, gamble4.timeBonus);

        Gamble gamble5 = new Gamble();
        int answer5 = gamble5.calculateBonus(38,40); //first number refers to second assertequals
        assertNotNull(answer5);
        assertEquals(200, gamble5.roundBonus);
        assertEquals(200, gamble5.timeBonus);
    }
}