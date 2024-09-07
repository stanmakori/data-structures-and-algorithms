package Codility.src.com.prefixsum.codility;

import java.util.HashSet;
import java.util.Set;

//https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/start/
public class MissingInteger {
    public int solution(int[] A) {
        // Implement your solution here
        Set<Integer> numbers = new HashSet<>();
        // Add only positive integers to the set
        for (int i = 0; i < A.length; i++){
            if(A[i] > 0) {
                numbers.add(A[i]);
            }
        }
        // start with 1 to find tghe missing number
        for (int j = 1; j < 100002; j++) { //cost maxmum value of an element is 100,000. so missing value can be 100,001 at worst
            if(!numbers.contains(j)) {
                return j;
            }
        }
        return 1;//this caters for negative numbers oinly which were not added to the set since set takes in only +ve numbers
    }
}
