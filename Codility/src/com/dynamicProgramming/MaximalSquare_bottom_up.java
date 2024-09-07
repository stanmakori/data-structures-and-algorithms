package Codility.src.com.dynamicProgramming;
//https://leetcode.com/problems/maximal-square/description/
//https://www.youtube.com/watch?v=4jBAHd0Xr90
//https://www.youtube.com/watch?v=_Lf1looyJMU
public class MaximalSquare_bottom_up {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m + 1][n + 1];

        int maxWidth = 0;

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    int top = cache[i - 1][j];
                    int left = cache[i][j - 1];
                    int topLeft = cache[i - 1][j - 1];//length diagonal
                    int min = Math.min(top, Math.min(left, topLeft));
                    cache[i][j] = min + 1;

                    //Update the max width
                    maxWidth = Math.max(maxWidth, cache[i][j]);
                }
            }
        }
        return maxWidth * maxWidth;
    }
    //my own solution after watching https://www.youtube.com/watch?v=_Lf1looyJMU
    public int maximalSquare1(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int cache[][] = new int[rows][cols];
        int maxSide = 0;
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j] == '1') {
                    int top = cache[i - 1 < 0 ? 0 : i -1][j];
                    int diagonal = cache[i - 1 < 0 ? 0 : i -1][j - 1 < 0 ? 0 : j -1];
                    int left = cache[i][j - 1 < 0 ? 0 : j -1];
                    int minVal = Math.min(Math.min(top, diagonal),Math.min(diagonal, left));
                    cache[i][j] = minVal + 1;
                    maxSide = Math.max(cache[i][j], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }
}
