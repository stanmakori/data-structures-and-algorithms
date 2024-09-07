package Codility.src.com.mathlogic;

public class GCD {
    // Method to calculate GCD using Euclidean Algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int gcd1(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int gcd2(int a, int b) {
        int minValue = Math.min(a, b);
        int maxValue = Math.max(a,b);
        while (minValue != 0) {
            int temp = minValue;
            minValue = maxValue % minValue;
            maxValue = temp;
        }
        return maxValue;
    }
    public static int gcd3(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = a % b;
            b = temp;
        }
        return a;
    }
    // Method to calculate LCM
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;
        int gcd = gcd(num1, num2);
        int lcm = lcm(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("GCD of " + num2 + " and " + num1 + " is: " + gcd);
        System.out.println("GCD of " + num2 + " and " + num1 + " is: " + gcd2(num1, num2));
        System.out.println("GCD of " + num2 + " and " + num1 + " is: " + gcd2(9, 24));
        System.out.println("GCD of " + num2 + " and " + num1 + " is: " + gcd2(30, 13));
//        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
//        System.out.println("modulus  " + 48 % 18);
//        System.out.println("modulus  " + 18 % 48);
        System.out.println("GCD of " + num2 + " and " + num1 + " is: " + gcd3(30, 13));
    }
}
