package Codility.src.com.binarysearch.leetcode;

public class LeetCode875_1 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum speed
        int right = getMax(piles); // Maximum speed

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if Koko can eat all bananas within h hours with speed mid
            if (canEatAll(piles, h, mid)) {
                // Koko can eat all bananas with speed mid or slower
                right = mid;
            } else {
                // Koko cannot eat all bananas with speed mid, increase speed
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            // Calculate hours needed to eat the pile with speed k
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
