package models;

/**
 * Created by caseybennett on 9/27/15.
 */
public class RunnableTimerTask implements Runnable {

    private Timer timer;
    private int startTime;
    private volatile boolean running = true;


    public RunnableTimerTask(Timer timer) {
        super();
        this.timer = timer;
        startTime = timer.getTime();

    }

    public void run() {

    }


}
