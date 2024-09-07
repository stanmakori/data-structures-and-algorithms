package com.dynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/valid-palindrome/solutions/546199/valid-palindrome/
//https://www.youtube.com/watch?v=IlEsdxuD4lY
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for(int[] arr : dp) {
            Arrays.fill(arr, 1);
        }
        for(int row = 1; row < m; row++) {
            for(int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];//compare previous row at the colm or current row at previous column
            }
        }
        return dp[m - 1][n - 1];//return top value
    }
    //opiton 2: top down approach
    Integer dp[][];
    public int uniquePaths1(int m, int n) {
        //recustion with memoization
        dp = new Integer[m][n];
        return uniquePathsRec(m, n,0,0) ;
    }
    int uniquePathsRec(int m, int n, int i, int j){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;//this is special because at this level, there is only one way to reach the corner
        if(dp[i][j]!=null) return dp[i][j];
        dp[i][j]= uniquePathsRec(m, n, i+1, j)+uniquePathsRec(m, n, i, j+1);

        return dp[i][j];
    }
}
