package Codility.src.com.prefixsum.codility;

import java.util.HashSet;
import java.util.Set;

public class FrogJump {
    //my solution . Works 100%
    public int solution(int X, int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();//store unique positions
        for (int i = 0; i < A.length; i++){
            set.add(A[i]);//add the position
            if(set.size() == X && set.contains(X)){ //cheque if we have covered every position
                return i;// return the time
            }
        }
        return -1;
    }
}
