package Codility.src.com.prefixsum.codility;

import java.util.HashSet;
import java.util.Set;

//https://martinkysel.com/codility-permcheck-solution/
public class PermCheck {
    public int solution(int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
        long max = Integer.MIN_VALUE;
        long sum = 0;
        for (int num : A){
            if(set.add(num)){
                max = Math.max(num, max);
                sum += num;
            }
        }
        long expectedSum = max * (1 + max) / 2;
        return expectedSum == sum && A.length == set.size()? 1: 0;
    }
}
