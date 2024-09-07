package Codility.src.com.binarysearch.fundamentals;

public class Test {
    private int findRow(int[][] matrix, int target){
        int lastCol = matrix[0].length - 1;
        for(int row = 0; row < matrix.length; row++) {
            if(matrix[row][lastCol] >= target){
                return row;
            }
        }
        return -1;
    }
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
            else if (matrix[row][mid] > target){
                right = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5}};
        Test test = new Test();
        System.out.println(test.findRow(matrix, 1));
        System.out.println(test.searchMatrix(matrix, 1));
    }
}
