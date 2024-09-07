package Codility.src.com.greedy.coinproblem;

import java.util.Arrays;

public class MinimumCoins {
    //given a set of coins, determine the minimum number of coins that can be give you the target sum
    //dp approach
    public int minCoins(int[] coins, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= target; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[target];
    }
    public int minCoinsGreedyApproach(int[] coins, int target) {
        // Sort the coins array in descending order
        Arrays.sort(coins);
        int numCoins = 0;

        // Iterate through the coins array in reverse order
        for (int i = coins.length - 1; i >= 0; i--) {
            // Calculate how many coins of current denomination can be used
            numCoins += target / coins[i];
            // Update the target amount for the next iteration
            target %= coins[i];
            // If the target amount becomes 0, break the loop
            if (target == 0) break;
        }

        // If the target amount is not fully covered, return -1
        if (target != 0) {
            return -1;
        }

        return numCoins;
        /*
        while greedy may work for some problems, it might not work for others.
        Secondly , it might not be optimal for some prpblems.
         */
    }
}
