package models;

/**
 * Representes a timer
 */
public class Timer {

    private int time;

    /**
     * Constructs a timer with the specified seconds.
     * 
     * @param seconds
     */
    public Timer(int time) {
        this.time = time;
    }

    /**
     * Decrements the timer by one second and returns the amount of time left in the timer 
     * after the decrement.
     * 
     *
     */
    public void decrementTimer() {
        time--;
    }

    /**
     * Returns the amount of time left in the timer.
     * 
     * @return time
     */
    public int getTime() {
        return time;
    }

    /**
     * Sets the timer to the specified number of seconds and returns the new time on the timer.
     * @param time
     */
    public void setTime(int time) {
        this.time = time;
    }
}
