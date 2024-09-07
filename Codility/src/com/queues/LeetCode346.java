package Codility.src.com.queues;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode346 {
    class MovingAverage {
        private Queue<Integer> queue;
        private int size;
        private double total;
        public MovingAverage(int size) {
            this.queue = new LinkedList<>();
            this.size = size;
            this.total = 0.0;
        }

        public double next(int val) {
            if (queue.size() == size) {
                total -= queue.poll();
            }
            queue.offer(val);
            total += val;
            return total / queue.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
