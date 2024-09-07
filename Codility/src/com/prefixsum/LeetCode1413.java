package Codility.src.com.prefixsum;

public class LeetCode1413 {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3};
        int result = minStartValue(nums);
        System.out.println(result);
    }

    public static int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return min >= 0 ? 1 : 1 - min;
    }
    public int minStartValue1(int[] nums) {
        int prefixSum = 0;
        int minValue = 0;
        //populate it
        for (int value : nums) {
            prefixSum += value;
            minValue = Math.min(minValue, prefixSum);

        }
        //iterate unitl we find the positive sum
        return 1 - minValue;

    }
}
