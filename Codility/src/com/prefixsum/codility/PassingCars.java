package Codility.src.com.prefixsum.codility;
//https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/start/
public class PassingCars {
    public int solution(int[] A) {
        int totalWest = 0; // Total number of cars traveling west
        for (int car : A) {
            if (car == 1) {
                totalWest++;
            }
        }

        int passingCars = 0;
        for (int car : A) {
            if (car == 0) {
                passingCars += totalWest; // Add the remaining westward cars for each eastward car
            } else {
                totalWest--; // One less car to the west to consider for future eastward cars
            }

            if (passingCars > 1_000_000_000) {
                return -1; // Check for overflow condition
            }
        }

        return passingCars;
    }
    public int solution1(int[] A) {
        int westCars = 0; // Total cars going west
        int passingCars = 0; // Total passing cars count

        // Loop through the array to count passing cars
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                westCars++; // If the car is going west, increment westCars
            } else {
                passingCars += westCars; // If the car is going east, add westCars to passingCars
                if (passingCars > 1_000_000_000) { // Check for overflow
                    return -1;
                }
            }
        }

        return passingCars;
    }
//    my own solution, using prefixSum approach
public int solution2(int[] A) {
    // Implement your solution here
    //build prefix sum of west moving cars
    int totalCars = A.length;
    int count = 0;
    int runningSum = 0;
    int[] prefixSum = new int[totalCars + 1];
    for (int i = prefixSum.length - 2; i >= 0; i--){
        if(A[i] == 1) {
            prefixSum[i] = 1 + prefixSum[i + 1];
        }
        else {
            prefixSum[i] = prefixSum[i + 1];
        }
    }
    for (int i = 0; i < A.length - 1; i++){
        if(A[i] == 0){
            count += prefixSum[i + 1] ;
            if(count > 1_000_000_000){
                return - 1;
            }
        }
    }
    return count;
}
}
