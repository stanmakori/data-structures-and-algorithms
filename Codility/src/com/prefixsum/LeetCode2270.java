package Codility.src.com.prefixsum;

public class LeetCode2270 {
//    prefix sum with additional space
    public int waysToSplitArray(int[] nums) {
        int numsLength = nums.length;
        long[] prefixSum = new long[numsLength];
        //prepopulate the prefix sum
        prefixSum[0] = nums[0];
        for(int i = 1; i < numsLength; i++){
            prefixSum[i] += nums[i] + prefixSum[i - 1];
        }
        int count = 0;
        for (int i = 0; i < numsLength - 1; i++){
            long leftSum = prefixSum[i];
            long righSum = prefixSum[numsLength - 1] - prefixSum[i];//rem prefix[j] - prefix[i - 1]
            if(leftSum >= righSum) {
                count++;
            }
        }
return count;

    }
    private int waysToSplitArrayOne(int[] nums) {
        long runningSum = 0;
        long totalSum = 0;
        int totalWaysToDivideArray = 0;
        //sum the cumulative array
        for (int n : nums) {
            totalSum += n;
        }
        //find left and right sums and compare
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[0];
            if(runningSum >= totalSum - runningSum) {
                totalWaysToDivideArray++;
            }
        }
        return totalWaysToDivideArray;
    }
}
