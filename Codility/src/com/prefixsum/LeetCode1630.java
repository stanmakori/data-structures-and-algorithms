package Codility.src.com.prefixsum;

import java.util.*;

public class LeetCode1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];

            int[] subArray = Arrays.copyOfRange(nums, left, right + 1);
            list.add(isArithmetic(subArray));
        }

        return list;
    }

    private boolean isArithmetic(int[] arr) {
        if (arr.length <= 2) {
            return true;
        }

        Arrays.sort(arr);

        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
    public List<Boolean> checkArithmeticSubarrays1(int[] nums, int[] l, int[] r) {
        List<Boolean> results = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            results.add(isArithmetic(nums, l[i], r[i]));
        }
        return results;
    }

    private boolean isArithmetic(int[] nums, int left, int right) {
        if (right - left + 1 <= 2) return true; // A subarray of two elements is always arithmetic

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> seen = new HashSet<>();

        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            seen.add(nums[i]);
        }

        int n = right - left + 1;
        if ((max - min) % (n - 1) != 0) return false; // Not evenly divisible, can't be arithmetic

        int diff = (max - min) / (n - 1);
        if (diff == 0) return seen.size() == 1; // Check for all elements being the same

        for (int i = 0; i < n; i++) {
            if (!seen.contains(min + i * diff)) return false; // Missing an expected element
        }

        return true;
    }
}
