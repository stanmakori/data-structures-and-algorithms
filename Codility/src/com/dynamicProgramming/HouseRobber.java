package com.dynamicProgramming;

public class HouseRobber {
//    https://leetcode.com/problems/house-robber/
    public int rob(int[] nums) {
        /**
         1. base case
         2. recursive or boundaries
         */
        int len=nums.length;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0],nums[1]);
        int dp[]= new int[nums.length];
        //the robber has two choices: rob the current house and move 2 steps forward
        //if he chooses not to rob the current house, he can simply move next
        int option1=0;
        int option2=0;
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            //rob current and move two steps forward
            option1= nums[i]+dp[i-2];
            //skip current house and check the next one
            option2 = dp[i-1];
            dp[i]=Math.max(option1, option2);
        }
        return dp[nums.length-1];
    }

    //house rober 2
//    https://leetcode.com/problems/house-robber-ii/description/
    /*
    This is slightly modified, we need to ensure that we dont end up in where we started,
    because the starting house is the neighbor of the last house too,
    unlike the houses in a straight line
     */
    public int robbber2(int[] nums) {
        int len=nums.length;
        if(len==1) return nums[0];
        if (len==2) return Math.max(nums[0],nums[1]);
        int amount1=0;
        int amount2=0;
        amount1=rob(nums,0,len-1);//end not necessarily length but where you started from
        amount2=rob(nums,1,len);//you can reach the end cos houses not adjacent
        return Math.max(amount1,amount2);

    }
    public int rob(int[] nums, int start, int end) {
        int sum=0;
        if(start >= end){
            return 0;
        }
        //then slightly tweak our house rbber one function
        int dp[]=new int[end];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        int i=start+2;
        for(; i<end;i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[end-1];
    }
    public int robOptimized(int[] nums) {
        if (nums.length == 1) {
            // To avoid out of bounds error from setting base case
            return nums[0];
        }

        int n = nums.length;

        // Base cases
        int backTwo = nums[0];
        int backOne = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // backTwo becomes backOne, and backOne gets updated
            int temp = backOne;
            backOne = Math.max(backOne, backTwo + nums[i]);
            backTwo = temp;
        }

        return backOne;
    }
}
