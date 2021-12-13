package application;

public class Timer extends Thread{
    private long startTime;
    private long stopTime;
    private boolean isRunning;
    private long elapsedTime;

    public Timer(){
        startTime = 0;
        stopTime = 0;
        isRunning = false;
        elapsedTime = 0;
    }

    public void startTimer(){
        this.startTime = System.currentTimeMillis();
        this.isRunning = true;
    }

    public void stopTimer(){
        this.stopTime = System.currentTimeMillis();
        this.isRunning = false;
        elapsedTime += calcElapsedTime();
    }

    public long calcElapsedTime() {
        long elapsed;
        if (isRunning) {
            elapsed = ((System.currentTimeMillis() - startTime));
        }
        else {
            elapsed = ((stopTime - startTime));
        }
        return elapsed;
    }

    public long getElapsedTime(){ return elapsedTime; }

}