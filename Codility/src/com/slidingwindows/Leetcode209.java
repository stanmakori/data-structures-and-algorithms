package Codility.src.com.slidingwindows;

public class Leetcode209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = minSubArrayLen(target, nums);
        System.out.println(result);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum += nums[right];
            while(sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
