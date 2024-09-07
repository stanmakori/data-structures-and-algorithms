package Codility.src.com.binarysearch.solutionspaces;

import java.util.Arrays;

public class LeetCode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum possible eating speed
        int right = Arrays.stream(piles).max().getAsInt(); // Maximum possible eating speed

        // Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2; // Middle point of the current search space
            if (canEatAllBananas(piles, h, mid)) {
                right = mid; // Try to find a smaller valid eating speed
            } else {
                left = mid + 1; // Increase the eating speed
            }
        }

        return left; // The minimum eating speed
    }

    // Helper method to determine if Koko can eat all bananas at speed k within h hours
    private boolean canEatAllBananas(int[] piles, int h, int k) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += (pile + k - 1) / k; // Calculate the total hours needed
        }
        return hoursNeeded <= h;
    }
}
