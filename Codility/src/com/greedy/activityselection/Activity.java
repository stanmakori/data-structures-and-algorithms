package Codility.src.com.greedy.activityselection;

public class Activity implements Comparable<Activity> {
    private final int startTime;
    private final int endTime;

    Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(Activity secondActivity) {
        return this.endTime - secondActivity.endTime;
    }
}
