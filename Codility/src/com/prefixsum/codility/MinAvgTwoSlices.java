package Codility.src.com.prefixsum.codility;
//https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/start/
public class MinAvgTwoSlices {
    public int solution(int[] A) {
        int N = A.length;
        // Create a prefix sum array where prefixSum[i] is the sum of A[0] to A[i-1]
        long[] prefixSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
        }

        int minIndex = 0;
        double minAverage = Double.MAX_VALUE;

        // Check every slice of length 2 and 3
        for (int i = 0; i < N - 1; i++) {
            // Check slice of length 2
            if (i + 1 < N) {
                double average2 = (double)(prefixSum[i + 2] - prefixSum[i]) / 2;
                if (average2 < minAverage) {
                    minAverage = average2;
                    minIndex = i;
                }
            }

            // Check slice of length 3
            if (i + 2 < N) {
                double average3 = (double)(prefixSum[i + 3] - prefixSum[i]) / 3;
                if (average3 < minAverage) {
                    minAverage = average3;
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }

}
