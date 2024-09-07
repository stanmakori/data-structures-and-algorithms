package Codility.src.com.binarysearch.solutionspaces;

/**
 * Solution class implements a solution for the MinMaxDivision problem.
 * Given integers K, M, and a non-empty array A consisting of N integers,
 * the goal is to divide array A into K blocks of consecutive elements such that:
 *  - Every element of the array belongs to some block.
 *  - The size of each block can be any integer between 0 and N.
 *  - The sum of each block should not exceed a target value (minimal large sum).
 *
 * The solution utilizes binary search to find the minimal large sum,
 * and a greedy algorithm to determine if it's possible to partition the array
 * into K blocks with each block sum less than or equal to the candidate minimal large sum.
 */
//https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
public class MinMaxDivision {

    /**
     * Finds the minimal large sum required to partition the array into K blocks.
     *
     * @param K The number of blocks desired from the array.
     * @param M The maximum possible value of elements in array A.
     * @param A The input array of integers.
     * @return The minimal large sum.
     */
    public int solution(int K, int M, int[] A) {
        // Find the maximum element and the sum of all elements in array A
        int maxElement = 0;
        int sumArray = 0;
        for (int num : A) {
            maxElement = Math.max(maxElement, num);
            sumArray += num;
        }

        // Initialize lower and upper bounds for binary search
        int lowerBound = maxElement;
        int upperBound = sumArray;

        // Perform binary search to find the minimal large sum
        while (lowerBound <= upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            if (isPossible(A, K, mid)) {
                upperBound = mid - 1;
            } else {
                lowerBound = mid + 1;
            }
        }

        return lowerBound; // Return the minimal large sum
    }

    /**
     * Checks if it's possible to partition the array into K blocks
     * such that each block has a sum less than or equal to the target.
     *
     * @param A      The input array of integers.
     * @param K      The number of blocks desired from the array.
     * @param target The target sum for each block.
     * @return True if it's possible, False otherwise.
     */
    private boolean isPossible(int[] A, int K, int target) {
        int sum = 0;
        int blocks = 1;
        // Iterate through array A and track the sum and number of blocks
        for (int num : A) {
            sum += num;
            // If the sum exceeds the target, start a new block
            if (sum > target) {
                sum = num;//this is how to start a new block
                blocks++;
            }
            // If the number of blocks exceeds K, it's not possible
            if (blocks > K) {
                return false;
            }
        }
        return true;
    }
}
