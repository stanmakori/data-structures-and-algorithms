package Codility.src.com.prefixsum.codility;

import java.util.Arrays;
//https://martinkysel.com/codility-maxcounters-solution/
public class MaxCounters {
    //optimal solution
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0; // Tracks the maximum value of any counter.
        int lastUpdate = 0; // Tracks the last universal max update value.

        for (int operation : A) {
            if (operation <= N) {
                // If the counter hasn't been updated since the last max operation,
                // reset it to the last max value.
                if (counters[operation - 1] < lastUpdate) {
                    counters[operation - 1] = lastUpdate;
                }

                // Increase the counter by one.
                counters[operation - 1]++;

                // Update the max if this counter is the new maximum.
                if (counters[operation - 1] > max) {
                    max = counters[operation - 1];
                }
            } else {
                // If a max counter operation is called, update the last universal max update.
                lastUpdate = max;
            }
        }

        // Ensure all counters are at least at the last max update value.
        for (int i = 0; i < N; i++) {
            if (counters[i] < lastUpdate) {
                counters[i] = lastUpdate;
            }
        }

        return counters;
    }
//    my own solution. 100% correct but 77% optimal - timesout on some cases
    public int[] solution1(int N, int[] A) {
        // Implement your solution here
        int[] counters = new int[N];
        int lastMax =  0;//to track current maxValue to avoid checking repeatedly
        for(int i = 0; i < A.length; i++) {
            if(A[i] <= N) {
                counters[A[i] - 1] += 1;
                int currentUpdate = counters[A[i] - 1];
                lastMax = Math.max(currentUpdate, lastMax);
            }
            else {
                Arrays.fill(counters, lastMax);
            }
        }
        return counters;
    }
}
