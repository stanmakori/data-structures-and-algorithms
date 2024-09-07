package Codility.src.com.greedy.knapsack.fractional;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort boxTypes based on the number of units per box
//        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);//same as above, but shorter and memorable
        int maxUnits = 0;
        for (int[] box : boxTypes) {
            int boxesTaken = Math.min(truckSize, box[0]);
            maxUnits += boxesTaken * box[1];
            truckSize -= boxesTaken;
            if (truckSize == 0) break;
        }

        return maxUnits;
    }
    //using priority queue
    public int maximumUnits1(int[][] boxTypes, int truckSize) {
        // Create a max heap based on the number of units per box
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        // Add boxTypes to the max heap
        for (int[] box : boxTypes) {
            maxHeap.offer(box);
        }

        int maxUnits = 0;

        // Keep extracting the top box from the heap and adding units until the truck is full
        while (!maxHeap.isEmpty() && truckSize > 0) {
            int[] box = maxHeap.poll();
            int boxesTaken = Math.min(truckSize, box[0]);
            maxUnits += boxesTaken * box[1];
            truckSize -= boxesTaken;
        }

        return maxUnits;
    }
}
