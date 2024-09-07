package Codility.src.com.binarysearch.solutionspaces;

import java.util.ArrayList;
import java.util.List;

public class LeetCode658 {
    /**
     * Finds the k closest elements to the target value x in a sorted array.
     *
     * @param arr The sorted array of integers.
     * @param k The number of closest elements to find.
     * @param x The target value to which elements should be close.
     * @return A list of the k closest elements to x.
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Initialize the result list to store the k closest elements
        List<Integer> result = new ArrayList<>();

        // Initialize left and right pointers to define the initial solution space
        int left = 0;
        int right = arr.length - 1;

        // Use a while loop to narrow down the solution space
        // The loop continues until the size of the solution space equals k
        while (right - left >= k) {
            // Compare the distances of the elements at the current boundaries (left and right) to x
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                // If the element at left is farther from x than the element at right,
                // increment left to exclude the left element from the solution space
                left++;
            } else {
                // Otherwise, decrement right to exclude the right element from the solution space
                right--;
            }
        }

        // After narrowing down, left and right define the bounds of the k closest elements
        // Collect the k closest elements into the result list
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        // Return the result list containing the k closest elements to x
        return result;
    }
}
