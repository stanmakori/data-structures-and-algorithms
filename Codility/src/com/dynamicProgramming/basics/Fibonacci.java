package Codility.src.com.dynamicProgramming.basics;
import java.util.*;
public class Fibonacci {
    Map<Integer, Integer> memo = new HashMap<>();
    int fibpnacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return fibpnacci(n - 1) + fibpnacci( n - 2);
        }
    }
    int fibpnacciOptimized(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            if( memo.containsKey(n)) {
                return memo.get(n);
            }
             memo.put(n, fibpnacciOptimized(n - 1) + fibpnacciOptimized(n - 2));
        }
        return memo.get(n);
    }
    int fibonnaciBottomUp(int n){
        int[] result = new int[n + 1];//up to the last value
        result[1] = 1;// since [0] is alreday 0
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}
