package Codility.src.com.dvivideandconquer.numberfactor;

public class Leetcode263 {
    public boolean isUgly(int n) {
        // A non-positive integer cannot be ugly
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        // Factorize by dividing with permitted factors
        //consider 30 which is common for the above, each can reduce it repeatedly to 1
        //but for a number like 9, the numbers 2 and 5 have no impact from divideAndConquer function.
        for (int factor : factors) {
            n = divideAndConquer(n, factor);
        }
        // Check if the integer is reduced to 1 or not.
        return n == 1;
    }
    private int divideAndConquer(int dividend, int divisor){
        while (dividend % divisor == 0) {
            dividend /= divisor;
        }
        return dividend;
    }
}
