package Codility.src.com.dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // Initialize dp array with 1 as LIS for each element is at least 1

        int globalMax = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // Check if the current number is greater than the number at index j
                // If it is, then it can be part of the increasing subsequence
                if (nums[i] > nums[j]) {
                    // Update the LIS length for index i
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Update the global maximum LIS length
            globalMax = Math.max(globalMax, dp[i]);
        }

        return globalMax;
    }
}
