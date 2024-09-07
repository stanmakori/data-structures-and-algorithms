package Codility.src.com.trees.LeetCode;

import Codility.src.com.trees.traversals.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode112 {
    //    Option 1: using recursion
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }

        currentSum += root.data;

        if (root.left == null && root.right == null && currentSum == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum, currentSum) || hasPathSum(root.right, targetSum, currentSum);
    }

    //    option 2: using iteration
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        nodeQueue.offer(root);
        sumQueue.offer(0); // Initialize sumQueue with 0 for the root

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int currentSum = sumQueue.poll() + node.data;

            if (node.left == null && node.right == null && currentSum == targetSum) {
                return true;
            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                sumQueue.offer(currentSum);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                sumQueue.offer(currentSum);
            }
        }

        return false;
    }
}
