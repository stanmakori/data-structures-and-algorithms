package com.trees.LeetCode;

import com.trees.TreeNode;

public class DiameterofBinaryTree {
    //    https://www.youtube.com/watch?v=9bCqmaIY2as&t=364s
//    https://leetcode.com/problems/diameter-of-binary-tree/description/
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
