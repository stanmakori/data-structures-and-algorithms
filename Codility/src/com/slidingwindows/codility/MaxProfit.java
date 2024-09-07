package Codility.src.com.slidingwindows.codility;
//https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
public class MaxProfit {
    public int solution(int[] A) {
        // Implement your solution here
        //check if empty
        int len = A.length;
        if(len <= 1) {
            return 0;
        }
        int minBuyingPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;;
        for (int i = 0; i < A.length; i++) {
            minBuyingPrice = Math.min(minBuyingPrice, A[i]);
            maxProfit= Math.max(maxProfit, A[i] - minBuyingPrice);
        }
        return maxProfit > 0 ? maxProfit: 0;
    }
}
