package Codility.src.com.dvivideandconquer.numberfactor;

import java.util.Arrays;

public class Leetcode279 {
    public int numSquares(int n) {
        // Create an array to store the minimum number of perfect squares for each number up to n
        int[] dp = new int[n + 1];

        // Initialize the array with maximum possible value
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: 0 requires 0 perfect squares
        dp[0] = 0;

        // Iterate from 1 to n
        for (int i = 1; i <= n; i++) {
            // Try all possible perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                // Update dp[i] if a smaller number of perfect squares is found
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        // The result is stored in dp[n]
        return dp[n];
    }
}
