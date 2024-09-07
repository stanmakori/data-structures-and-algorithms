package Codility.src.com.backtracking;

import java.util.*;

public class NQueens {
    private static int N;

    // Function to solve N-Queens problem using backtracking
    private static List<List<String>> solveNQueens(int n) {
        N = n;
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[N][N];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(result, board, 0);
        return result;
    }

    // Backtracking function to find all solutions
    private static void backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == N) {
            result.add(constructSolution(board));
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(result, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    // Function to check if placing a queen at board[row][col] is valid
    private static boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
            int diff = row - i;
            if (col - diff >= 0 && board[i][col - diff] == 'Q') return false;
            if (col + diff < N && board[i][col + diff] == 'Q') return false;
        }
        return true;
    }

    // Helper function to construct solution from board
    private static List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
