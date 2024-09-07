package Codility.src.com.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class LeetCode17 {
    // Mapping of digits to corresponding letters
    private static final Map<Character, String> phoneMap = new HashMap<>();

    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        backtrack(digits, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> combinations) {
        // Base case: if current combination is of same length as digits, add to result
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }
        // Get letters corresponding to current digit
        String letters = phoneMap.get(digits.charAt(index));
        // Iterate over each letter and backtrack
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Choose
            backtrack(digits, index + 1, current, combinations); // Explore
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
