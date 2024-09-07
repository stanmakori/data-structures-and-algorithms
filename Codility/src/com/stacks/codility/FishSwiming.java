package Codility.src.com.stacks.codility;
import java.util.Stack;
//https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
public class FishSwiming {
    public int solution(int[] A, int[] B) {
        // Create two stacks to keep track of fish sizes and their directions
        Stack<Integer> fishStack = new Stack<>();
        Stack<Integer> directionsStack = new Stack<>();
        // Iterate over each fish in the given arrays
        for (int i = 0; i < A.length; i++) {
            int size = A[i];         // Size of the current fish
            int direction = B[i];    // Direction of the current fish
            // Check if the stack is empty, or the current fish moves in the same direction as the previous fish,
            // or if the current fish is swimming downstream (direction == 1)
            if (fishStack.isEmpty() || direction == directionsStack.peek() || direction == 1) {
                // If any of the above conditions are met, add the current fish to the stack without confrontation
                fishStack.push(size);           // Push the size of the current fish onto the fish stack
                directionsStack.push(direction); // Push the direction of the current fish onto the direction stack
            } else {
                // If the current fish is swimming upstream (direction == 0) and encounters a fish moving downstream,
                // or if the current fish is larger than the fish moving in the opposite direction,
                // keep removing fish moving in the opposite direction until there are no more fish to remove,
                // or until the current fish is smaller than or equal to the fish in the stack
                while (!fishStack.isEmpty() && direction != directionsStack.peek() && size > fishStack.peek()) {
                    fishStack.pop();            // Remove the fish from the fish stack
                    directionsStack.pop();      // Remove the corresponding direction from the direction stack
                }
                // After removing smaller fish moving in the opposite direction,
                // or if the current fish is swimming in the same direction as the previous fish,
                // add the current fish to the stack without further comparison
                if (fishStack.isEmpty() || direction == directionsStack.peek()) {
                    fishStack.push(size);           // Push the size of the current fish onto the fish stack
                    directionsStack.push(direction); // Push the direction of the current fish onto the direction stack
                }
            }
        }
        // The size of the fish stack represents the number of surviving fish
        return fishStack.size();
    }
}
