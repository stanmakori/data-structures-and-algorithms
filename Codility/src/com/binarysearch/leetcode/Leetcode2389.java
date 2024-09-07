package Codility.src.com.binarysearch.leetcode;

import java.util.Arrays;

public class Leetcode2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        //sort the arrays
        Arrays.sort(nums);
        //build prefix sum
        int[] result = new int[queries.length];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        //apply binary search to find the n
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i];
            int left = 0, right = nums.length -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    result[i] = mid + 1;
                    break;
                }
                else if (nums[mid] < target) {
                    left = mid+1;
                    result[i] = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }
}
