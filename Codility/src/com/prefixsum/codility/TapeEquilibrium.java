package Codility.src.com.prefixsum.codility;
//https://martinkysel.com/codility-tape-equilibrium-solution/
public class TapeEquilibrium {
    public int Solution(int[] A) {
        // Initialize variables
        int leftSum = 0;
        int globalSum = 0;
        int globalMin = Integer.MAX_VALUE;

// Calculate the total sum of the array
        for (int value : A) {
            globalSum += value;
        }

// Iterate through the array to find the minimal absolute difference
        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i]; // Incrementally update the left sum
            int rightSum = globalSum - leftSum; // Calculate the right sum based on the total sum and left sum
            int currentDifference = Math.abs(leftSum - rightSum); // Find the absolute difference
            globalMin = Math.min(currentDifference, globalMin); // Update the global minimum difference if necessary
        }

        return globalMin;

    }
}
