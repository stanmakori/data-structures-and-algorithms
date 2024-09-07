package com.trees.LeetCode;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
//
public class TreeTraversals {
    //preorder traversal
//    https://leetcode.com/problems/binary-tree-preorder-traversal/description/
    ArrayList<Integer> list=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        //add root data. formular root=>left=>right
        if(root==null) return list;//we have reached the end. Return what we have or an empty list
        list.add(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.data);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
//    https://leetcode.com/problems/binary-tree-inorder-traversal/description/
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return list;
        inorderTraversal(root.left);
        list.add(root.data);
        inorderTraversal(root.right);
        return list;
    }
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.data);
            curr = curr.right;
        }
        return res;
    }
//    https://leetcode.com/problems/binary-tree-postorder-traversal/description/
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.data);
        return list;
    }
}
