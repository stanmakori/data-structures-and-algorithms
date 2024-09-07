package Codility.src.com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs70 {
    //option 1: using bottom up
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        //base cases
        dp[0] = 0; //implied. zero ways to climb if there is no staircase
        dp[1] = 1;//only one way to climb 1 staircase
        dp[2] = 2;// only two ways to climb two starcases

        //recurrence relation
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    //option 2
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbingStares1(int n){
        //base cases
        if(n == 0 || n == 1) {
            return 1;
        }
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, climbingStares1(n - 1) + climbingStares1(n - 2));
        return cache.get(n);
    }
}
