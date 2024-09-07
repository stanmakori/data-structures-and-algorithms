package Codility.src.com.string;

public class Leetcode8Atoi {
        public int myAtoi(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }

            int index = 0;
            int sign = 1;
            long result = 0;

            // Trim leading whitespace
            while (index < s.length() && s.charAt(index) == ' ') {
                index++;
            }

            // Check for sign
            if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
                sign = s.charAt(index) == '+' ? 1 : -1;
                index++;
            }

            // Process digits
            while (index < s.length()) {
                char currentChar = s.charAt(index);
                if (!Character.isDigit(currentChar)) {
                    break;
                }

                int digit = currentChar - '0';
                result = result * 10 + digit;

                // Check for overflow
                if (result * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (result * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

                index++;
            }

            return (int) (sign * result);
        }
}
