package Codility.src.com.dynamicProgramming;
//https://www.youtube.com/watch?v=QfZvw8_jz1w&t=44s
public class LongestPalindromicSubstring {
        public String longestPalindrome(String s) {
            // Initialize variables to keep track of the boundaries of the longest palindromic substring
            int left = 0, right = 0, len = 0;

            // Iterate over each character in the string
            for(int i = 0; i < s.length(); i++) {
                // Expand around the center for odd-length palindromes (single character center)
                int odd = expandCenter(s, i, i);
                // Expand around the center for even-length palindromes (two characters center)
                int even = expandCenter(s, i , i + 1);

                // Get the maximum length between the odd-length and even-length palindromes
                len = Math.max(odd, even);

                // If the current palindrome length is greater than the previously found longest palindrome
                if(len > right - left) {
                    // Update the left boundary of the longest palindromic substring
                    left = i - (len - 1) / 2;
                    // Update the right boundary of the longest palindromic substring
                    right = i + len / 2;
                }
            }

            // Return the longest palindromic substring
            return s.substring(left, right + 1);
        }

        // Helper method to expand around the center and find the length of the palindrome
        private int expandCenter(String s, int left, int right){
            // Expand while the characters at left and right are equal and within bounds
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            // Return the length of the palindrome
            return right - left - 1;
        }

}
