package Codility.src.com.stacks;

import java.util.*;

public class LeetCode71 {
    public String simplifyPath(String path) {
        // Use a deque as a stack to store directories
        Deque<String> stack = new ArrayDeque<>();

        // Set of directories to skip during processing
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

        // Split the input path by "/"
        for (String dir : path.split("/")) {
            // If the directory is ".." and stack is not empty, pop the top directory
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
            // If the directory is not in skip set, push it onto the stack
            else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }

        // Construct the simplified path string by appending directories from the stack
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.insert(0, "/" + dir); // Insert each directory at the beginning of the result string
        }

        // Return "/" if the result string is empty, otherwise return the result string
        return result.length() == 0 ? "/" : result.toString();
    }

}
