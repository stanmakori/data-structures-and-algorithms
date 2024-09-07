package Codility.src.com.trees.LeetCode;

import Codility.src.com.trees.traversals.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            // If the tree is empty, create a new node with the given value and return it as the new root
            return new TreeNode(val);
        }

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);

        while (!bfs.isEmpty()) {
            TreeNode current = bfs.poll();
            int rootValue = current.data;

            if (val < rootValue) {
                // If the value is less than the current node's value, explore the left subtree
                if (current.left == null) {
                    // If the left child is null, insert the new node here
                    current.left = new TreeNode(val);
                    break; // No need to continue BFS
                } else {
                    // Otherwise, continue BFS with the left child
                    bfs.offer(current.left);
                }
            } else {
                // If the value is greater than or equal to the current node's value, explore the right subtree
                if (current.right == null) {
                    // If the right child is null, insert the new node here
                    current.right = new TreeNode(val);
                    break; // No need to continue BFS
                } else {
                    // Otherwise, continue BFS with the right child
                    bfs.offer(current.right);
                }
            }
        }
        return root;
    }
}
