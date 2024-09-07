package com.trees.LeetCode;

import com.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    Map<String, int[]> map = new HashMap<String, int[]>();
    /*
       Invert childNodes
       Then swap the children
       Time complexity is 0(n) because we visit each node and do constant operation
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        //swap left and right descendants
        TreeNode curr = root.right;
        root.right = root.left;
        root.left = curr;
        //then do it recursively
        invertTree(root.left);
        invertTree(root.right);


        return root;
    }
}
