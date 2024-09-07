package Codility.src.com.dynamicProgramming;

//https://leetcode.com/problems/longest-common-subsequence/description/
//https://www.youtube.com/watch?v=sSno9rV8Rhg&t=42s
public class LongestCommonSubsequence {
    //my solution that works like a jam
    Integer dp[][];

    public LongestCommonSubsequence(String s1, String s2) {
        //we have already initialized the memo, instead of doing it at the main method
        this.dp = new Integer[s1.length()][s2.length()];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0);

    }
//This works because both strings are at least 1 character long. But if one is empty,
// you need extra space
    public int longestCommonSubsequence(String text1, String text2, int l1, int l2) {

        //base case
        if (l1 == text1.length() || l2 == text2.length()) return 0;

        //if already computed
        if (dp[l1][l2] != null) return dp[l1][l2];

        //continuously same
        if (text1.charAt(l1) == text2.charAt(l2))
            dp[l1][l2] = 1 + longestCommonSubsequence(text1, text2, l1 + 1, l2 + 1);

            //if not, either add string s to string2 or add string2 to string1
        else
            dp[l1][l2] = Math.max(longestCommonSubsequence(text1, text2, l1 + 1, l2), longestCommonSubsequence(text1, text2, l1, l2 + 1));

        return dp[l1][l2];

    }
}
