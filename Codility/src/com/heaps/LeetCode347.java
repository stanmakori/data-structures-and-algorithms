package Codility.src.com.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)
                -> frequencyMap.get(b) - frequencyMap.get(a) );
        //populate the map
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        //populate priority queue to sort them
        for (int key : frequencyMap.keySet()) {
            maxHeap.offer(frequencyMap.get(key));
            if(maxHeap.size() == k){
                break;
            }
        }
        return maxHeap.stream().mapToInt(Integer::intValue).toArray();
    }
}
