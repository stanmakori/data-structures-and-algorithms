package com.trees.LeetCode;

import com.trees.TreeNode;

//https://github.com/neetcode-gh/leetcode/blob/main/java/110-Balanced-Binary-Tree.java
//https://www.youtube.com/watch?v=QfJsau0ItOY
//https://leetcode.com/problems/balanced-binary-tree/
//https://www.youtube.com/watch?v=LU4fGD-fgJQ
public class BalancedBinaryTree {
    boolean isBalanced(TreeNode root)
    {
        //check if null
        //check if each side is balanced
        //check if max difference between left and right is 1 or less
        if(root==null)
        {
            return true;//already balanced
        }
        if( Math.abs(height(root.left)-height(root.right))>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }
    private int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    public void printTree(TreeNode root)
    {
        // Function to print tree nodes in InOrder fashionif (root != null) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }
    public void printTree1(TreeNode root)
    {
        // Function to print tree nodes in InOrder fashionif (root != null) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + "--> ");
            printTree(root.right);
        }
    }
public static void main(String[] args)
{
    TreeNode tree=new TreeNode().arrayToTree(new Integer[]{3,9,20,null,null,15,7});
    new BalancedBinaryTree().printTree1(tree);
    System.out.println(new BalancedBinaryTree().isBalanced(tree));

    //case 2
    tree=new TreeNode().arrayToTree(new Integer[]{1,2,2,3,3,null,null,4,4});
    System.out.println(new BalancedBinaryTree().isBalanced(tree));

    //case2
    tree=new TreeNode().arrayToTree(new Integer[]{});
    System.out.println(new BalancedBinaryTree().isBalanced(tree));


}
}
