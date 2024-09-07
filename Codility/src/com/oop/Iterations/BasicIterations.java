package com.oop.Iterations;

public class BasicIterations {
    private int sum = 0;
    public int compute() {
        int x = 0;
        while (x < 3) {
            sum += x++;
        }
        return sum;
    }
    public static void main(String[] args) {
        BasicIterations bc = new BasicIterations();
        int sum = bc.compute(); //global sum = 3, local sum = 3
        sum = bc.compute();// global sum = 6 , local = 6
        bc.compute();// global = 9 ,local =6
        System.out.println(sum);
        System.out.println(bc.sum);

    }

}
