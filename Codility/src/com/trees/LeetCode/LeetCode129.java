package Codility.src.com.trees.LeetCode;

import Codility.src.com.trees.traversals.TreeNode;

public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        return dfsHelper(root, 0);

    }
    private int dfsHelper(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        //This is the real deal: it accumulates the sum of numbers represented by root-to-leaf paths
        //in the binary tree.
        if(root.left == null && root.right == null) {
            return sum * 10 + root.data;
        }
        return dfsHelper(root.left, sum * 10 + root.data)
                + dfsHelper(root.right, sum * 10 + root.data);
    }
}
