package com.trees.LeetCode;

import com.trees.TreeNode;
//https://leetcode.com/problems/path-sum/description/
//https://www.youtube.com/watch?v=k1JWRnYV_t0
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //base case
        if (root == null) return false;
        return dfsRec(root, targetSum);
    }
    boolean dfsRec(TreeNode root, int targetSum) {
        targetSum -= root.data;
        if( root.left == null && root.right == null) return targetSum==0;
        // This MUST be defined a fresh here for each path !
        boolean left = false;
        boolean right = false;
        if (root.left != null) left =  dfsRec(root.left, targetSum);
        if (root.right != null) right = dfsRec(root.right, targetSum);
        return left || right ;
    }
}
