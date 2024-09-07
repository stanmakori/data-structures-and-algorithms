package Codility.src.com.binarysearch.solutionspaces;

import java.util.Arrays;

public class LeetCode1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        // Lower bound of solution space
        int left = 1;

        // Upper bound of solution space
        int right = Arrays.stream(nums).max().getAsInt(); // Maximum number in the array

        // Perform binary search on the solution space
        while (left < right) {
            // Calculate mid-point of current solution space
            int mid = left + (right - left) / 2;

            // Calculate the sum of divisions with current mid as the divisor
            if (sumOfDivisions(nums, mid) <= threshold) {
                // If sum is within threshold, move upper bound to mid
                right = mid;
            } else {
                // If sum exceeds threshold, move lower bound to mid + 1
                left = mid + 1;
            }
        }

        // Return the smallest valid divisor
        return left;
    }

    // Helper method to calculate the sum of divisions with rounding up
    private int sumOfDivisions(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            // Calculate division result and round up
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }
}
