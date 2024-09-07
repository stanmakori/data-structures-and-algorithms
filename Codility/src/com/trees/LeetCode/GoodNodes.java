package com.trees.LeetCode;

import com.trees.TreeNode;
//https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
//https://www.youtube.com/watch?v=Ho22p_2JBWA
public class GoodNodes {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.data);
    }

    public int dfs(TreeNode node, int maxSoFar) {
        //base case check
        if( node == null) return 0;

        //update the maxSoFar
        maxSoFar = Math.max(maxSoFar, node.data);

        //if it if a good node, then dfs on it
        if(node.data >= maxSoFar) {
            return  1+ dfs(node.left,maxSoFar)+dfs(node.right,maxSoFar);
        }
        //otherwise it is a bad one e.g i>i+1
        else {
            return  dfs(node.left,maxSoFar)+dfs(node.right,maxSoFar);
        }
    }
}
