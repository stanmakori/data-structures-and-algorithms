package Codility.src.com.greedy.activityselection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activityselection {
    public static List<Activity> selectedActivities(Activity[] activities) {
        List<Activity> selectedActivities = new ArrayList<>();
        Arrays.sort(activities);
        selectedActivities.add(activities[0]);
        Activity previousActivity = activities[0];
        // If the current activity's start time is after the end time of the last selected activity,
        // add the current activity to the list of selected activities
        for (int i = 0; i < activities.length; i++) {
            Activity currentActivity = activities[i];
            if (currentActivity.getStartTime() >= previousActivity.getEndTime()) {
                selectedActivities.add(currentActivity);
                previousActivity = currentActivity;
            }
        }
        return selectedActivities;
    }
    public static void main(String[] args) {
        Activityselection as = new Activityselection();
        Activity[] activities = {
                new Activity(1, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(3, 8),
                new Activity(5, 9),
                new Activity(6, 10),
                new Activity(8, 11),
                new Activity(8, 12),
                new Activity(2, 13),
                new Activity(12, 14)
        };

        List<Activity> selectedActivities = selectedActivities(activities);

        System.out.println("Selected Activities:");
        for (Activity activity : selectedActivities) {
            System.out.println("[" + activity.getStartTime() + ", " + activity.getEndTime() + "]");
        }
    }
}
