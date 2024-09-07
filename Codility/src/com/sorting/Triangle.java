package Codility.src.com.sorting;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] A) {
        // Edge case: if the array size is less than 3, cannot form a triangle
        if (A.length < 3) {
            return 0;
        }

        // Sort the array to make it easier to find potential triangles
        Arrays.sort(A);

        // Iterate through the array and check if any triplet can form a triangle
        for (int i = 0; i < A.length - 2; i++) {
            // Use long to prevent integer overflow
            long a = A[i];
            long b = A[i + 1];
            long c = A[i + 2];

            if (a + b > c && b + c > a && a + c > b) {
                return 1; // Found a valid triangle
            }
        }

        // No valid triangle found
        return 0;
    }
    //solution1 : mine but essentially similat to the above
    public int solution1(int[] A) {
        // Implement your solution here
        int len = A.length;
        //edge case 1: size is less hence cannot form a triangle
        if(len <= 2) {
            return 0;
        }
        Arrays.sort(A);
        int start = 0, mid = 1, last = 2;
        while (last < A.length) {
            long p = A[start];
            long q = A[mid];
            long r = A[last];
            if(p + q > r &&
                    q + r > p &&
                    r + p > q
            ){
                return 1;
            }
            start++;
            mid++;
            last++;
        }
        return 0;
    }
}
