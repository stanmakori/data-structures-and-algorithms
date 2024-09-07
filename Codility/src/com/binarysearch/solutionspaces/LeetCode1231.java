package Codility.src.com.binarysearch.solutionspaces;

public class LeetCode1231 {
    public int maximizeSweetness(int[] sweetness, int K) {
        int left = 1, right = 0;

        // Calculate the total sweetness
        for (int sweet : sweetness) {
            right += sweet;
        }

        // Binary search for the maximum sweetness
        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (canDivide(sweetness, K, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canDivide(int[] sweetness, int K, int target) {
        int count = 0, currentSum = 0;

        for (int sweet : sweetness) {
            currentSum += sweet;
            if (currentSum >= target) {
                count++;
                currentSum = 0;
            }
        }

        return count >= K + 1;
    }
}
