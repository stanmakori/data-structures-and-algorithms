package Codility.src.com.heaps;

import java.util.PriorityQueue;

public class HeapStreams {
    void streamPQ(){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        pq.add(10);
        pq.add(-3);
        pq.add(12);
        Integer[] nums = (Integer[]) pq.toArray();
        pq.clear();
    }
}
