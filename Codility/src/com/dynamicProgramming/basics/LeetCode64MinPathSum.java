package Codility.src.com.dynamicProgramming.basics;

public class LeetCode64MinPathSum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Create a dp array with the same dimensions as grid
        int[][] dp = new int[rows][cols];

        // Initialize the top-left cell
        dp[0][0] = grid[0][0];

        // Fill the first row
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // Fill the first column
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the remaining cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // Return the value at the bottom-right cell
        return dp[rows - 1][cols - 1];
    }
}
