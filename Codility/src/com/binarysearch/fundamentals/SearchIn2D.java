package Codility.src.com.binarysearch.fundamentals;
//https://leetcode.com/problems/search-a-2d-matrix/description/
public class SearchIn2D {
    //my own solutions
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if(row == -1) {
            return false;
        }
        int right = matrix[0].length - 1;
        int left = 0;
        while(left <= right) {
            int mid = left + (right - left) /2;
            if(matrix[row][mid] == target) {
                return true;
            }
            else if(matrix[row][mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
    //find possible row - O(rows) since you iterate all rows
     private int findRow0(int[][] matrix, int target){
         int lastCol = matrix[0].length - 1;
         for(int row = 0; row < matrix.length; row++) {
             if(matrix[row][lastCol] >= target){
                 return row;
             }
         }
         return -1;
     }
     //find row - binary search the rows at last column
    private int findRow(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix is empty or null");
        }

        int M = matrix.length;
        int N = matrix[0].length;

        int left = 0;
        int right = M - 1;
        int resultRow = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = matrix[mid][N - 1];

            if (value >= target) {
                resultRow = mid;
                right = mid - 1; // Search in the upper half
            } else {
                left = mid + 1; // Search in the lower half
            }
        }

        return resultRow;
    }
}
