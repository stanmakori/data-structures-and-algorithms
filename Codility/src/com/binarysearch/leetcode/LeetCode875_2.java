package Codility.src.com.binarysearch.leetcode;

public class LeetCode875_2 {
    //simplest logic
    public int minEatingSpeed(int[] piles, int h) {
        int minBananas = 1;
        int maxBananas = 1000_000_001;

        while (minBananas < maxBananas) {
            int k = minBananas + (maxBananas - minBananas) / 2;
            int time = 0;

            for (int i = 0; i < piles.length; i++) {
                // Use Math.ceil() to calculate the number of hours
                // required for the current pile
                time += Math.ceil((double) piles[i] / k);
            }

            if (time > h) {
                minBananas = k + 1;
            } else {
                maxBananas = k;
            }
        }

        return minBananas;
    }
    //option 2: works faster than above seemingly Math.ceil() introduces overheads
    public int minEatingSpeed1(int[] piles, int h) {
        // Initialize the minimum and maximum possible eating speeds
        int minBananas = 1; // Minimum speed is 1 banana per hour
        int maxBananas = 1000_000_001; // Maximum speed is set to a large value

        while (minBananas < maxBananas) {
            // Calculate the midpoint eating speed using binary search
            int k = minBananas + (maxBananas - minBananas) / 2;
            int time = 0;

            for (int i = 0; i < piles.length; i++) {
                // If the current pile has fewer bananas than the eating speed
                if (piles[i] <= k) {
                    // Koko can finish the pile in 1 hour
                    time++;
                } else {
                    // Otherwise, we need to calculate the number of hours required
                    // to finish the pile with the given eating speed

                    // The expression (piles[i] + k - 1) / k is used to calculate
                    // the number of hours needed to finish the pile with proper rounding up

                    // piles[i] is the number of bananas in the current pile
                    // k is the eating speed in bananas per hour

                    // If piles[i] is divisible by k, (piles[i] + k - 1) / k will
                    // be equal to piles[i] / k, giving the correct number of hours

                    // If piles[i] is not divisible by k, (piles[i] + k - 1) will
                    // be greater than piles[i], ensuring that the division rounds up

                    // For example, if piles[i] is 17 and k is 5:
                    // piles[i] + k - 1 = 17 + 5 - 1 = 21
                    // 21 / 5 = 4 (integer division rounds down)
                    // This correctly gives the number of hours needed (4) to
                    // finish the pile of 17 bananas when eating 5 bananas per hour

                    time += (piles[i] + k - 1) / k;
                }
            }

            // Check if the calculated time exceeds the given time limit (h)
            if (time > h) {
                // If it does, increase the minimum eating speed
                minBananas = k + 1;
            } else {
                // Otherwise, update the maximum eating speed
                maxBananas = k;
            }
        }

        // Return the minimum eating speed that allows Koko to
        // finish all the piles within the given time limit
        return minBananas;
    }
}
