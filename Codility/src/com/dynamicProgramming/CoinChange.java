package com.dynamicProgramming;

import java.util.Arrays;
import static java.lang.Math.min;

//https://leetcode.com/problems/coin-change/description/
//https://www.youtube.com/watch?v=J0C_FDmYwpg
//https://www.youtube.com/watch?v=H9bfqozjoqs
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len=coins.length;
        if(amount<=0) return 0; //we cant return 0 or less

        //2: dp to hold the amounts. length = amount+ , just like Fib(n) where dp[]=dp[n+1]
        int dp[]=new int[amount+1];
        //3: populte it with amount tat we wont use, i.e higher than the amount, including Integer.MAX_VALUE-1
        Arrays.fill(dp,amount+20);//anything >amount but less than Integer.MAX_VALUE
         dp[0]=0;//we dont want to build 0 amounts
        //ironically, the amount becomes like length
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                //we need the min of current pre-populated value, compared with previous
                //i is money. j is also money. just like solitare where you sub 6 steps behind
                if(coins[j]<=i){//skip some lengths which go outside the boundary
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];//coins can only be <=amount cos they are full coins.

    }
    //better simple approach
//    https://www.youtube.com/watch?v=hxaTNNQmx4c
//    https://www.youtube.com/watch?v=hxaTNNQmx4c
    public int coinChange1(int[] coins, int amount) {
        //amount = 15
        //
        int dp[] = new int [amount +1]; //16
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int coin: coins){
            for(int i = coin; i < dp.length; i++){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[dp.length -1] == amount +1? -1: dp[dp.length-1];
    }

    //coin change 2
//    https://leetcode.com/problems/coin-change-ii/description/
//    https://leetcode.com/problems/coin-change-ii/solutions/430649/coin-change-ii/ for explanation
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] = dp[i]+dp[i - coin];
            }
        }
        return dp[dp.length-1];
    }
}

