package Codility.src.com.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MatrixSearch {
    public static boolean searchElement(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Use a queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();

        // Start BFS from the first row
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0});
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Check if we found the target
            if (matrix[row][col] == target) {
                return true;
            }
            // If the current element is less than the target,
            // we can move to the right (if possible)
            if (col + 1 < n && matrix[row][col + 1] <= target) {
                queue.offer(new int[]{row, col + 1});
            }
        }
        return false; // Target not found
    }
    static boolean isFoundRowWise(int[][] matrix, int target) {
        int rows = matrix.length;
        int colIndex = 0;
        //int maxDepth = Integer.MAX_VALUE;
        int maxDepth= 0;
        for(int[] nums : matrix) {
            maxDepth= Math.max(nums.length, maxDepth);
        }
        while(colIndex < maxDepth) {
            int row = 0;
            while (row < rows) {
                if(colIndex < matrix[row].length && matrix[row][colIndex] == target) {
                    return true;
                }
                row++;
            }
               colIndex++;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 3},
                {5, 7}
        };
        int target1 = 3; // Present in matrix1
        int target2 = 4; // Absent in matrix1

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target3 = 5; // Present in matrix2
        int target4 = 10; // Absent in matrix2

        // Creating a long matrix with an infinite first row
        int n = 1000000; // A large number
        int[][] matrix3 = new int[3][n];
        for (int i = 0; i < n; i++) {
            matrix3[0][i] = i + 1;
            matrix3[1][i] = i + n + 1;
            matrix3[2][i] = i + 2 * n + 1;
        }
        int target5 = n + 2; // Present in matrix3

        System.out.println("Test case 1: " + searchElement(matrix1, target1));
        System.out.println("Test case 2: " + !searchElement(matrix1, target2));
        System.out.println("Test case 3: " + searchElement(matrix2, target3));
        System.out.println("Test case 4: " + !searchElement(matrix2, target4));
        System.out.println("Test case 5: " + searchElement(matrix3, target5));
        System.out.println("====RowWise Approach======");
        System.out.println("Test case 1: " + isFoundRowWise(matrix1, target1));
        System.out.println("Test case 2: " + isFoundRowWise(matrix1, target2));
        System.out.println("Test case 3: " + isFoundRowWise(matrix2, target3));
        System.out.println("Test case 4: " + isFoundRowWise(matrix2, target4));
        System.out.println("Test case 5: " + isFoundRowWise(matrix3, target5));
    }
}
