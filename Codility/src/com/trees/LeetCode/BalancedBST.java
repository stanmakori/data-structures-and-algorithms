package com.trees.LeetCode;

import com.trees.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/description/
public class BalancedBST {
    //sol1: my solution passing 60/80 cases
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;

        if(lefHelper(root.left, root.data) && rightHelper(root.right, root.data)){
            return true;
        }
        return false;
    }
    boolean lefHelper(TreeNode root, int rootVal)
    {
        if(root!=null){
            lefHelper(root.left, rootVal);
            if(root.data>=rootVal) return false;
        }
        return true;
    }
    boolean rightHelper(TreeNode root, int rootVal)
    {
        if(root!=null){
            rightHelper(root.right, rootVal);
            if(root.data<=rootVal) return false;
        }
        return true;
    }
    //option 1: working soln 100% fast
    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal)
    {
        if(root==null) return true;
        if(root.data>=maxVal || root.data<=minVal) return false;
        return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);
    }

    //option 3: recustion


    public boolean isValidBST2(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.data <= low) || (high != null && root.data >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.data, high) && validate(root.left, low, root.data);
    }
}
