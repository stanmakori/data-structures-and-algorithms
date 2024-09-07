package Codility.src.com.dvivideandconquer.numberfactor;

public class NumberFactor {
//    Given N, calculate how many ways can N be expressed as a factor of 1, 3 and 4
    public int waysToGetN(int n){
        //base cases
        if (n == 0 || n == 1 || n == 2) {
            return 1;//there is only one way ,that's the numbers themselves.
        }
        if (n == 3) {
            return 2;// either {1,1,1} or {3}
        }
        return waysToGetN(n - 1) + waysToGetN(n - 3) + waysToGetN(n - 4);
    }
    public int waysToGetNDP(int n){
        //base cases
        int[] dp = new int[n + 1];
        for (int i = 0; i <= 2; i++){
            dp[i] = 1;//only one way to express the numbers
        }
        dp[3] = 2;
        for (int i = 4 ; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[ i - 4];
        }
        return dp[n];
    }
    public int waysToGetTopDown(int n, int[] cache){
        //base cases
        if ( n == 0 || n == 1 || n == 2) {
            return 1;
        }
        else if (n == 3) {
            return 2;
        }
        else {
            if (cache[n] == 0) {
                int subProblemOne = waysToGetTopDown(n - 1, cache);
                int subProblemTwo = waysToGetTopDown(n - 3, cache);
                int subProblemThree = waysToGetTopDown(n - 4, cache);
                cache[n] = subProblemOne + subProblemTwo + subProblemThree;
            }
//            else {
//                return cache[n];
//            }
        }

        return cache[n];
    }
    public static void main(String...args) {
        //8
        System.out.println(new NumberFactor().waysToGetN(8));
        System.out.println(new NumberFactor().waysToGetNDP(8));
        //4
        System.out.println(new NumberFactor().waysToGetN(4));
        System.out.println(new NumberFactor().waysToGetNDP(4));
        //5
        System.out.println(new NumberFactor().waysToGetN(5));
        System.out.println(new NumberFactor().waysToGetNDP(5));
        //6
        System.out.println(new NumberFactor().waysToGetN(6));
        System.out.println(new NumberFactor().waysToGetNDP(6));
        //top down
        System.out.println(new NumberFactor().waysToGetTopDown(6, new int[7]));
    }
}
