package Codility.src.com.slidingwindows;

public class LeetCode1456 {
    public static void main(String[] args) {
        String s = "abcabc";
        int k = 2;
        int result = maxVowels(s, k);
        System.out.println(result);
    }

    public static int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int count = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            if(isVowel(c)) {
                count++;
            }
            if(right - left + 1 == k) {
                max = Math.max(max, count);
                char leftChar = s.charAt(left);
                if(isVowel(leftChar)) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return max;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u';
    }
}
