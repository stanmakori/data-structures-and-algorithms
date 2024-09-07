package Codility.src.com.stacks;

import java.util.Arrays;
import java.util.Stack;

public class Basics {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
    public static void main(String[] args) {
        String[] ops = new String[]{"5","-2","4","C","D","9","+","+"};
        int sum = calPoints(ops);
        System.out.println(sum);
        System.out.println("===Interesting facts about stack printing values===");
        int[][] sortedInterevals = new int[][] {{1, 6}, {8, 10}, {15, 18}};
        Stack<int[]> stack = new Stack<>();
        for(int[] value : sortedInterevals) {
            stack.push(value);
        }
//        elements printed in the insertion order, not LIFO order !
        System.out.println(Arrays.deepToString(stack.toArray()));

    }
}
