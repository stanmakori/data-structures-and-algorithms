package Codility.src.com.intervals.overlappingintervals;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] preInterval = stack.peek();

            // Merge the interval if they overlap
            if (intervals[i][0] <= preInterval[1]) {
                preInterval[1] = Math.max(intervals[i][1], preInterval[1]);
            } else {
                // Add the interval onto the stack if they don't overlap
                stack.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        return stack.toArray(new int[stack.size()][2]);
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        LeetCode56MergeIntervals lm = new LeetCode56MergeIntervals();
        System.out.println(Arrays.deepToString(lm.merge(intervals)));
    }
}
