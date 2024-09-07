package Codility.src.com.dynamicProgramming.basics;

public class TriBonacci {
    //    https://leetcode.com/problems/n-th-tribonacci-number/editorial/
//    option 1: no extra space
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }
        return c;
    }

    public int tribonacci1(int n) {
        if (n < 3) {
            return n > 0? 1:0;
        }
        int[] dp = new int[n+1];
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] +dp[i-3];
        }
        return dp[n];
    }
}
