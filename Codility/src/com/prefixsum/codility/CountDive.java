package Codility.src.com.prefixsum.codility;
//https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/start/
public class CountDive {
    public int solution(int A, int B, int K) {
        // Count of divisible numbers up to B
        int upToB = B / K;// e.g 1 - 20 k = 3 .  20/3 = 6. how ? 3,6,9,12,15,18!

        // Count of divisible numbers before A (special handling if A is 0)
        // A - 1 to accommodate or include A in scenarios where  A itself is divisible by k
        int beforeA = A == 0 ? -1 : (A - 1) / K;

        // The difference plus one to correct the count
        return upToB - beforeA;
    }
}
