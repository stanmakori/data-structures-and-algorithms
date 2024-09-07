package Codility.src.com.string;

import java.util.HashSet;
//https://www.youtube.com/watch?v=yk_Aw1ibOfc
public class LeetCode36Sudok {
    public boolean isValidSudoku(char[][] board) {
        // Use HashSet to check for duplicates
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    // Check row
                    if (!seen.add(current + " in row " + i)) return false;
                    // Check column
                    if (!seen.add(current + " in column " + j)) return false;
                    // Check 3x3 sub-box
                    if (!seen.add(current + " in box " + i/3 + "-" + j/3)) return false;
                }
            }
        }

        return true;
    }
}
