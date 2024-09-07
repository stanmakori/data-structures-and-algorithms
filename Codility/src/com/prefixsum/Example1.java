package Codility.src.com.prefixsum;

public class Example1 {
    static boolean[] test1(){
       int[] nums ={1, 6, 3, 2, 7, 2};
       int[][] queries = {{0, 3}, {2, 5}, {2, 4}};
       int limit = 13;
       int[] prefixSum = new int[nums.length];
       int sum = 0;
       int index = 0;
       boolean[] result = new boolean[queries.length];
       // populate the prefix sum
        for (int i =0; i < nums.length; i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int subArraySum = prefixSum[end] - prefixSum[start] + nums[start];
//            if (subArraySum < limit) {
//                result[index++] = true;
//            }
            result[index++] = subArraySum < limit;
        }

        return result;

    }
}
