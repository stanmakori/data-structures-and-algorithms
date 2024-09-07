package Codility.src.com.trees.LeetCode;

import Codility.src.com.trees.traversals.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> currentNodes = new LinkedList<>();
        currentNodes.offer(root);
        int sum = 0;

        while (!currentNodes.isEmpty()) {
            int size = currentNodes.size();
            sum = 0; // Reset sum for the current level

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = currentNodes.poll();
                sum += currentNode.data; // Accumulate the sum for the current level

                if (currentNode.left != null) {
                    currentNodes.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    currentNodes.offer(currentNode.right);
                }
            }
        }

        return sum; // Return the sum of the deepest leaves
    }
}
