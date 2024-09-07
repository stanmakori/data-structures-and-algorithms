package Codility.src.com.commonalgorithms.codility;

import java.util.HashSet;
import java.util.Set;

//https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
public class NumberOfChocolates {
//    my solution. Not optimal but works 100%
    public int solution(int N, int M) {
        // Implement your solution here
        /*
        N - number of chocolates
        M - determines the next possible chocolate index?
        Range : 1 - 1B
        N = 10, M = 4
        0->4 ->8 -> 2 ->6 ->

        steps :
        1 - set to store unique chocolates
        2 - add each index
        3 - break when a repeat index is encounteted
        return the size of the set
        */
        Set<Integer> setOfChocolates = new HashSet<>();
        int nextIndex = 0;
        while(true) {
            if(setOfChocolates.contains(nextIndex)){
                break;
            }
            setOfChocolates.add(nextIndex);
            nextIndex = (nextIndex + M) % N;
        }
        return setOfChocolates.size();
    }
    //optimal, using gcd and lcm
    public int solution1(int N, int M) {
        // Calculate the greatest common divisor (GCD) of N and M
        // int gcd = gcd(N, M);

        // Calculate the least common multiple (LCM) of N and M
        long lcm = lcm(N, M);

        // Calculate the number of chocolates eaten
        return (int)(lcm / M);
    }

    // Function to find the greatest common divisor (GCD) of two numbers using Euclidean Algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // Function to find the least common multiple (LCM) of two numbers
    private long lcm(int a, int b) {
        return (long)a * b / gcd(a, b);
    }
}
