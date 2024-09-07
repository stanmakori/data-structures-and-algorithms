package Codility.src.com.greedy.knapsack.fractional;

import java.util.*;

public class LeetCode2279 {
//    my own solution. borrowing from top k elements and greedy pattern
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        Map<Integer, Integer> deficityMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> deficityMap.get(a) -        deficityMap.get(b));
        for (int i = 0; i < rocks.length; i++) {
            deficityMap.put(i, capacity[i] - rocks[i]);
            pq.add(i);
        }
        int count = 0;//chose to use count as opposed to rocks.length - pq.size cos some conditions might not be filfilled
        while(!pq.isEmpty() && additionalRocks > 0){
            int currentIndex = pq.poll();
            int deficity = capacity[currentIndex] - rocks[currentIndex];
            if(deficity <= additionalRocks){
                additionalRocks -= deficity;
                count++;
            }
            else {
                break;
            }

        }
        return count;
    }
    public int maximumBags1(int[] capacity, int[] rocks, int additionalRocks) {
        int[] deficits = new int[rocks.length];
        for (int i = 0; i < rocks.length; i++){
            deficits[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(deficits);
        int fullBags = 0;
        for (int deficit : deficits) {
            if (deficit <= additionalRocks){
                additionalRocks -= deficit;
                fullBags++;
            }
        }
        return fullBags;
    }
}
