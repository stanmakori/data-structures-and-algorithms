package Codility.src.com.slidingwindows.codility;

public class MaxSliceSum {
    /**
     * Finds the maximum sum of any slice (contiguous subsequence) in the array.
     * This method implements an optimized version of Kadane's Algorithm, which is efficient and works by
     * dynamically updating the current maximum sum at each step of the iteration through the array.
     *
     * @param A The input array containing integers, which can be both positive and negative.
     *          It's assumed that the array is not null and has at least one element.
     * @return The maximum sum of any contiguous subsequence within the array. If the array contains only
     *         one element, that element is returned as it constitutes the maximum sum itself.
     *
     * The method works as follows:
     * 1. It first checks if the array has only one element, in which case it returns that element immediately,
     *    as it's the maximum sum by default.
     * 2. It initializes `maxSum` with the minimum possible integer value to ensure that any sum found is greater.
     * 3. It sets `currentSum` to 0 as the starting point for calculating contiguous sums.
     * 4. The method iterates through each element of the array. For each element, it decides whether to
     *    add the element to the existing `currentSum` or start a new sum with the current element. This decision
     *    is based on which of the two is larger, effectively choosing the more promising path towards a larger sum.
     * 5. `maxSum` is updated to reflect the largest sum found so far in the iteration.
     * 6. Once all elements have been processed, `maxSum`, which now holds the maximum sum of any contiguous
     *    subsequence, is returned.
     *
     * Note: This algorithm is efficient with a linear time complexity of O(n), where n is the number of elements in
     * the input array, because it only requires a single pass through the array.
     */
    public int solution(int[] A) {
        int len = A.length;
        // Immediate return for single-element arrays
        if (len == 1){
            return A[0];
        }

        int maxSum = Integer.MIN_VALUE; // Initialize maxSum with the lowest possible value
        int currentSum = 0; // Initial current sum before iteration starts

        for (int i = 0; i < len; i++) {
            // Update currentSum to be either the current element or sum of currentSum and the current element,
            // whichever is larger. This decides whether to extend the current subsequence or start a new one.
            currentSum = Math.max(A[i], A[i] + currentSum);
            // Update maxSum to be the larger between the current maxSum and currentSum
            maxSum = Math.max(maxSum, currentSum);
        }
        // Return the largest sum found
        return maxSum;
    }

}
