package Codility.src.com.queues;
import java.util.ArrayDeque;
import java.util.Deque;
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // Remove indices of elements not in the sliding window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove smaller elements from the end of the deque
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offer(i);

            // Add the maximum element for the current window to the result array
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }
        return result;
    }
}
