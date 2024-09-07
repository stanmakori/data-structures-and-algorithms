package Codility.src.com.basics;

public class PrimitiveBehavior {
    public static void main(String[] args) {
        int testValue = 20; // testValue is a primitive with value 20
        changeValue(testValue);
        System.out.println(testValue); // Prints 20 because the original value is unchanged
    }

    private static void changeValue(int testValue) {
        testValue = 35; // The local variable testValue is changed, but it doesn't affect the original value
    }
}

