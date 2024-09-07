package Codility.src.com.codilitytests;

public class Question {
    /*
    Write a function to find the longest common prefix string amongst an array of strings.

        If there is no common prefix, return an empty string "".

        Example 1:

        Input: strs = ["flow", "flower","flight"]
        Output: "fl"
        Example 2:

        Input: strs = ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.
      Input: strs = ["flow", "flow","flow"]
        Constraints:

        1 <= strs.length <= 200
        0 <= strs[i].length <= 200
        strs[i] consists of only lowercase English letters.
     */
    String longestCommonPrefix(String[] strs) {
        //length of the first string.
        int prefixLength = strs[0].length();
        for (int i = 0; i < prefixLength; i++) {
            for (String str : strs) {
                if (i == prefixLength || str.charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
