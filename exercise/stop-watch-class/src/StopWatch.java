import java.util.Date;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public Date star() {
        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        startTime = millis;
        return date;
    }
    public Date stop() {
        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        endTime = millis;
        return date;
    }
    public long getElapsedTime() {
        return endTime - startTime;
    }
}
