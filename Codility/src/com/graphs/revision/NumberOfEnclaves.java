package com.graphs.revision;

import java.util.LinkedList;
import java.util.Queue;
//https://takeuforward.org/graph/number-of-enclaves/
//https://leetcode.com/problems/number-of-enclaves/
//https://www.youtube.com/watch?v=rxKcepXQgU4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=22

public class NumberOfEnclaves {
    int numberOfEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<Pair>();
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        // traverse boundary elements
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // first row, first col, last row, last col
                if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    // if it is a land then store it in queue
                    if(grid[i][j] == 1) {
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, +0, -1};

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            // traverses all 4 directions
            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                // check for valid coordinates and for land cell
                if(nrow >=0 && nrow <n && ncol >=0 && ncol < m
                        && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }

        }
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // check for unvisited land cell
                if(grid[i][j] == 1 & vis[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;

    }
    public static void main(String[] args)
    {
        int grid[][] = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        NumberOfEnclaves ob = new NumberOfEnclaves();
        int ans = ob.numberOfEnclaves(grid);
        System.out.println(ans);
    }

}
class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    //my own solution
    class Solution {
        private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int numEnclaves(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            boolean[][] isVisited = new boolean[rows][cols];
            //sink edge rows
            for (int col = 0; col < cols; col++) {
                if (grid[0][col] == 1) {
                    enclavesDepthFirstSearch(0, col, grid, isVisited);
                }

            }
            for (int col = 0; col < cols; col++) {
                if (grid[rows - 1][col] == 1) {
                    enclavesDepthFirstSearch(rows - 1, col, grid, isVisited);
                }

            }


            //sink columns
            for (int row = 0; row < rows; row++) {
                if (grid[row][0] == 1) {
                    enclavesDepthFirstSearch(row, 0, grid, isVisited);
                }

            }
            for (int row = 0; row < rows; row++) {
                if (grid[row][cols - 1] == 1) {
                    enclavesDepthFirstSearch(row, cols - 1, grid, isVisited);
                }

            }

            //check the lands that were unvisited cos neigbors or next neigbors were water

            int count = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (!isVisited[i][j] && grid[i][j] == 1) count++;
                }
            }
            return count;

        }

        //check if out of boundary
        private boolean isOutOfBoundary(int row, int col, int[][] grid) {
            return (row < 0 || col < 0 || row >= grid.length
                    || col >= grid[0].length);
        }

        private void enclavesDepthFirstSearch(int row, int col, int[][] grid, boolean[][] isVisited) {
            //if out of boudnary, skip
            if (isOutOfBoundary(row, col, grid) || isVisited[row][col] || grid[row][col] == 0) {
                return;
            }
            //otherwise , sink the neigbors
            isVisited[row][col] = true;
            for (int[] dir : dirs) {
                enclavesDepthFirstSearch(dir[0] + row, dir[1] + col, grid, isVisited);
            }
            return;
        }
    }

    //end of my solution

    //solution 2, remove unnecessary use of isVisited
    class Solution2 {

        int dirs[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int numEnclaves(int[][] grid) {
            // remove all boundary  and connected 1s
            for (int i = 0; i < grid.length; i++) {
                dfp(grid, i, 0);
                dfp(grid, i, grid[0].length - 1);
            }
            for (int j = 0; j < grid[0].length; j++) {
                dfp(grid, 0, j);
                dfp(grid, grid.length - 1, j);
            }
            // count remaining 1s
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) count++;
                }
            }
            return count;
        }

        private void dfp(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
                return;
            }
            grid[i][j] = 0;//sink it
            for (int dir[] : dirs) {
                dfp(grid, i + dir[0], j + dir[1]);
            }
        }
    }

    //no call to dirs , unncessesary
    class Solution3 {
        public int numEnclaves(int[][] grid) {
            // remove all boundary  and connected 1s
            for(int i=0; i<grid.length; i++){
                dfp(grid,i,0);
                dfp(grid,i,grid[0].length-1);
            }
            for(int j=0; j<grid[0].length; j++){
                dfp(grid,0,j);
                dfp(grid,grid.length-1,j);
            }
            // count remaining 1s
            int count = 0;
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j] == 1) count++;
                }
            }
            return count;
        }
        private void dfp(int[][] grid, int i, int j){
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
                return;
            }
            grid[i][j] = 0;//sink it
            //I found that avoiding loops and doing direct dfs saves a lot of time!
            dfp(grid,i+1,j);
            dfp(grid,i-1,j);
            dfp(grid,i,j+1);
            dfp(grid,i,j-1);
        }
    }
}
