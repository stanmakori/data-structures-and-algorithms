package Codility.src.com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;

        int dp[] = new int[len + 1];//to escape boundaries/index out of bounds
//        you can ignore because we can start at step 0 or step 1 meaning cost in both is zero
        dp[0] = dp[1] = 0;//
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[len];

    }

    //    Better
//    https://www.youtube.com/watch?v=OoGswqFU-zs
//
    public int minCostClimbingStairsGreedyApproach(int[] cost) {

        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
    int minCostOneStep = 0;
    int minCostTwoSteps = 0;

    //my own approach 26/03/2024
    public int minCostClimbingStairs3(int[] cost) {
        int minCostOneStep = minCostClimbingStairs(cost, cost.length - 1);
        int minCostTwoSteps = minCostClimbingStairs(cost, cost.length - 2);
        return Math.min(minCostOneStep, minCostTwoSteps);
    }

    private int minCostClimbingStairs(int[] cost, int index) {
        //base case for top down approach
        if (index < 0) {
            return 0;
        } else {
            if (memo.containsKey(index)) {
                return memo.get(index);
            }
            minCostOneStep = cost[index] + minCostClimbingStairs(cost, index - 1);
            minCostTwoSteps = cost[index] + minCostClimbingStairs(cost, index - 2);
            memo.put(index, Math.min(minCostOneStep, minCostTwoSteps));
        }
        return Math.min(minCostOneStep, minCostTwoSteps);
    }
}
