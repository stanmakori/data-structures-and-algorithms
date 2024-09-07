package Codility.src.com.greedy.codility;
//https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
public class MaxNonOverlappingSegments {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        if (N == 0) return 0; // No segments

        int count = 1; // At least one segment is non-overlapping
        int lastEnd = B[0]; // Initialize the end of the last selected segment

        // Iterate through the segments
        for (int i = 1; i < N; i++) {
            // If the start of the current segment is after the end of the last selected segment,
            // select the current segment and update the end of the last selected segment
            if (A[i] > lastEnd) {
                count++;
                lastEnd = B[i];
            }
        }

        return count;
    }
}
