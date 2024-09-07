package Codility.src.com.arrays;

public class SecondMaxInArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 15, 30};
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax && arr[i] != firstMax) {
                // Update secondMax only if the current element is greater than the current secondMax
                // and is not equal to the firstMax to ensure a distinct second maximum.
                secondMax = arr[i];
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            System.out.println("No second maximum element found.");
        } else {
            System.out.println("Second maximum element is: " + secondMax);
        }
    }
}
