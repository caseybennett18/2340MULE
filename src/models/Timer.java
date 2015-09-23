package models;

/**
 * Created by Admin on 9/22/15.
 */
public class Timer {

    private int time;

    public Timer(int time) {
        this.time = time;
    }

    public int decrementTimer() {
        time--;
        return time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
