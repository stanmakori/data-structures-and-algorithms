package Codility.src.com.dynamicProgramming;

public class LongestCommonSubstringTopDown {
    Integer[][] dp;

    public static int longestCommonSubstring(String text1, String text2, int i,
                                             int j, Integer[][] dp) {

        // Base cases
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        // Check if already computed
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Find the longest common substring considering two options
        int option1 = 0; // No match at current positions
        int option2 = 0; // Match at current positions

        if (text1.charAt(i) == text2.charAt(j)) {
            option2 = 1 + longestCommonSubstring(text1, text2, i + 1, j + 1, dp);
        }

        option1 = Math.max(longestCommonSubstring(text1, text2, i + 1, j, dp),
                longestCommonSubstring(text1, text2, i, j + 1, dp));

        // Store the result for future reference
        dp[i][j] = Math.max(option1, option2);

        return dp[i][j];
    }

    public int longestCommonSubstring(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        this.dp = new Integer[m][n];

        // Initialize a memoization table with -1 (indicating not computed yet)
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i][j] = -1;
//            }
//        }

        return longestCommonSubstring(text1, text2, 0, 0, dp);
    }

    public static void main(String[] args) {
        LongestCommonSubstringTopDown lcs = new LongestCommonSubstringTopDown();
        String text1 = "abcde";
        String text2 = "ace";
        int length = lcs.longestCommonSubstring(text1, text2);
        System.out.println("Length of longest common substring: " + length);
        String s3 = "evanson";
        String s4 = "devan";
        System.out.println(lcs.longestCommonSubstring(s3, s4));
        s3 = "sendora";
        s4 = "ondora";
        System.out.println(lcs.longestCommonSubstring(s3, s4));
        String s5 = "Onkangi";
        String s6 = "";
        System.out.println(lcs.longestCommonSubstring(s5, s6));
        String s7 = "fghiabcd";
        String s8 = "abc";
        System.out.println(lcs.longestCommonSubstring(s7, s8));
    }
}
