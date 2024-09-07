package Codility.src.com.mathlogic;

import java.util.Scanner;

public class SimplifiedTimeRepresentation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of seconds: ");
        long totalSeconds = scanner.nextLong();
        scanner.close();

        String result = simplifyTime(totalSeconds);
        System.out.println(result);
    }

    private static String simplifyTime(long totalSeconds) {
        long secondsInMinute = 60;
        long secondsInHour = 60 * secondsInMinute;
        long secondsInDay = 24 * secondsInHour;
        long secondsInWeek = 7 * secondsInDay;

        long weeks = totalSeconds / secondsInWeek;
        totalSeconds %= secondsInWeek;

        long days = totalSeconds / secondsInDay;
        totalSeconds %= secondsInDay;

        long hours = totalSeconds / secondsInHour;
        totalSeconds %= secondsInHour;

        long minutes = totalSeconds / secondsInMinute;
        totalSeconds %= secondsInMinute;

        long seconds = totalSeconds;

        StringBuilder result = new StringBuilder();

        if (weeks > 0) result.append(weeks).append("w");
        if (days > 0) result.append(days).append("d");
        if (hours > 0) result.append(hours).append("h");
        if (minutes > 0) result.append(minutes).append("m");
        if (seconds > 0) result.append(seconds).append("s");

        String output = result.toString();

        if (output.length() > 2) {
            String[] units = {"w", "d", "h", "m", "s"};
            for (String unit : units) {
                int index = result.indexOf(unit);
                if (index != -1) {
                    result = new StringBuilder(result.substring(0, index + 1));
                    break;
                }
            }
        }

        return result.toString();
    }
}

