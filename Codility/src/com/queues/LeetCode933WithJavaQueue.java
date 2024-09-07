package Codility.src.com.queues;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode933WithJavaQueue {
    class RecentCounter {
        Queue<Integer> callQueue ;
        public RecentCounter() {
            this.callQueue = new LinkedList<>();
        }

        public int ping(int t) {
            while(!callQueue.isEmpty() && t - callQueue.peek()> 3000) {
                callQueue.poll();
            }
            callQueue.offer(t);
            return callQueue.size();
        }
    }
}
