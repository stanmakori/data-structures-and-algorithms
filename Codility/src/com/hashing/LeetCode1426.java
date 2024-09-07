package Codility.src.com.hashing;

import java.util.Arrays;

public class LeetCode1426 {
    public int countElements(int[] arr) {
        Arrays.sort(arr); // Sort the array in place
        int count = 0;
        int prevCount = 0;
        int prevNum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prevNum + 1) {
                count += prevCount + 1; // Increment count by the previous count plus 1
                prevCount = 0; // Reset the previous count
            } else if (arr[i] == prevNum) {
                prevCount++; // Increment the previous count if the current number is the same as the previous one
            } else {
                prevCount = 0; // Reset the previous count
            }
            prevNum = arr[i]; // Update the previous number
        }

        return count;
    }
}
