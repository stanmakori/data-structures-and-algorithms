package Codility.src.com.commonalgorithms;

import java.util.HashSet;
import java.util.Set;

public class EuclideanAlgorithm {
    /*
    - find divisors
    - find common divisors
    - find the bigest
     */
    private int findGCD(int a, int b){
        //put them in set to filder out duplicates
        Set<Integer> divisorsOfA = new HashSet<>();
        Set<Integer> divisorsOfB = new HashSet<>();
        Set<Integer> commonDivisors = new HashSet<>();
        for (int i = 1 ;i <= a; i++){
            if (a % i == 0) {
                divisorsOfA.add(i);
            }
        }
        for (int i = 1 ; i <= b; i++ ){
            if(b % i == 0){
                divisorsOfB.add(i);
            }
        }
        for (int n : divisorsOfA){
            if(divisorsOfB.contains(n)){
                commonDivisors.add(n);
            }
        }
        int maxDivisor = Integer.MIN_VALUE;
        for (int n : commonDivisors){
            maxDivisor = Math.max(maxDivisor, n);
        }
        return maxDivisor;
    }
    public int findGCDOptimal(int a, int b) {
        // Ensure a is greater than or equal to b
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        // Apply the Euclidean Algorithm
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a; // 'a' will hold the GCD
    }
    private int gcdMultipleNumbers(){
        /*
        gcd(a, b, c) {
    return gcd(a, gcd(b, c)); do gcd n times where n is the number of inputs

         */
        return 0;
    }
    private int lcmBasic(int a, int b){
        //formulat lcm(a,b ) = a*b /(gcd(a,b))
        //find gcd of a & b
        int gcd = findGCDOptimal(a, b);

        return a * b / gcd;
    }
    private int lcmMultiple(int...nums){
        // Initialize the result to the first number in the array
        int result = nums[0];

        // Iterate through the rest of the numbers in the array
        for (int i = 1; i < nums.length; i++) {
            // Calculate the LCM of the current number and the current result
            result = lcmBasic(result, nums[i]);
        }

        return result;
    }
    public static void main(String[] args){
        EuclideanAlgorithm uc = new EuclideanAlgorithm();
        System.out.println("3 ==" +uc.findGCD(12, 33));
        System.out.println("1 ==" +uc.findGCD(8, 33));
        System.out.println("10 ==" +uc.findGCD(10, 100));
        System.out.println("3 ==" +uc.findGCD(15, 48));
        System.out.println("4 ==" +uc.findGCD(12, 64));
        System.out.println("=========GCD Optimized========");
        System.out.println("3 ==" +uc.findGCDOptimal(12, 33));
        System.out.println("1 ==" +uc.findGCDOptimal(8, 33));
        System.out.println("10 ==" +uc.findGCDOptimal(10, 100));
        System.out.println("3 ==" +uc.findGCDOptimal(15, 48));
        System.out.println("4 ==" +uc.findGCDOptimal(12, 64));
        System.out.println("=========Least common multiples========");
        System.out.println("48 ==" +uc.lcmBasic(12, 16));
        System.out.println("=========Least common multiple of dynamic inputs========");
        System.out.println("LCM of 12, 16 & 24 = 48 =" +uc.lcmMultiple(12, 16, 24));
        System.out.println("LCM of 12, 16 , 24 & 32 = 96 =" +uc.lcmMultiple(12, 16, 24, 32));
    }
}
