package com.trees.LeetCode;

import com.trees.TreeNode;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);

    }
    private TreeNode sortedArrayToBST(int[] nums, int left, int right)
    {
        if(left>right){
            return null;//because if l>r , then no more nodes or elements on the subtree
        }
        int p=(left+right)/2;
        TreeNode root= new TreeNode(nums[p]);//pick the middle value as root
        root.left=sortedArrayToBST(nums, left,p-1);
        root.right=sortedArrayToBST(nums, p+1,right);
        return root;
    }
}
