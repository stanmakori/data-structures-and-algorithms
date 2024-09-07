package Codility.src.com.binarysearch.leetcode;
import java.util.*;
public class LeetCode875 {
    // Method to find the minimum eating speed
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum possible eating speed
        int right = Arrays.stream(piles).max().getAsInt(); // Maximum possible eating speed

        // Binary search to find the minimum eating speed
        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate the middle eating speed
            int hours = calculateHours(piles, mid); // Calculate hours needed to eat all bananas with speed mid

            if (hours > h) {
                // Need to increase the eating speed
                left = mid + 1;
            } else {
                // Can try a lower eating speed
                right = mid;
            }
        }

        return left; // Return the minimum eating speed
    }
    // Method to calculate the total hours needed to eat all bananas with given speed k
    private int calculateHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            // Calculate hours needed to eat the pile with speed k
            hours += Math.ceil((double) pile / k);
        }
        return hours;
    }
}
