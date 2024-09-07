package Codility.src.com.queues;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperation {
    static void queeueInitialization(){
        Queue<Integer> queue = new LinkedList<>();
    }
    static void ops() {
        var stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);


        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(5);
        if (stack.empty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println(String.format("Stack is not empty, top is: %d", stack.peek()));
        }
    }
    static void peeking(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.peek());
        }

    }
    static void dequeue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll());
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> numsQueue = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currentMax = Integer.MIN_VALUE;
            if(numsQueue.size() == k) {
                for (int j = 0; j < k; j++) {
                    currentMax = Math.max(currentMax , numsQueue.get(j));
                }
                result.add(currentMax);
                numsQueue.remove(0);
            }
            numsQueue.add(nums[i]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        new BasicStackOperation().peeking();
    }
}
