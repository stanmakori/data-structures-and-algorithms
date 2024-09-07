package Codility.src.com.dynamicProgramming;

public class LongestCommonSubstring1 {
    Integer dp[][];
        public int longestCommonSubstring(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            this.dp = new Integer[m][n];

            // Initialize a memoization table to store subproblem results
            int[][] dp = new int[m + 1][n + 1];

            // Find the longest common substring length
            int maxLength = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // If characters match, extend the current substring
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        maxLength = Math.max(maxLength, dp[i][j]);
                    } else {
                        // No match, reset the substring length for this cell
                        dp[i][j] = 0;
                    }
                }
            }

            return maxLength;
        }

        public static void main(String[] args) {
            String text1 = "abcde";
            String text2 = "ace";
            int length = new LongestCommonSubstring1().longestCommonSubstring(text1, text2);
            System.out.println("Length of longest common substring: " + length);

        }

}
