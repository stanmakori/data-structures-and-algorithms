package com.graphs.revision;

import java.util.HashSet;

//https://leetcode.com/problems/number-of-distinct-islands/description/
//https://www.youtube.com/watch?v=7zmgQSJghpo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=17
public class NumberOfDistinctIslands {
    private final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numDistinctIslands(int[][] grid) {
        var set = new HashSet<String>();
        int rows = grid.length;
        int cols = grid[0].length;

        // Create a copy of the grid to avoid modifying the input
        int[][] copyGrid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(grid[i], 0, copyGrid[i], 0, cols);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (copyGrid[i][j] == 1) {
                    String islandShape = islandDFS(i, j, copyGrid, "");
                    set.add(islandShape);
                }
            }
        }

        return set.size();
    }

    private boolean isOutOfBoundary(int row, int col, int[][] grid) {
        return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
    }

    private String islandDFS(int row, int col, int[][] grid, String shape) {
        if (isOutOfBoundary(row, col, grid) || grid[row][col] == 0) {
            return shape;
        }

        grid[row][col] = 0; // Mark visited

        shape += "D"; // Down
        for (int[] direction : directions) {
            shape = islandDFS(row + direction[0], col + direction[1], grid, shape);
            shape += "U"; // Up (backtrack)
        }

        return shape;
    }
}
