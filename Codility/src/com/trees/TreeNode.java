package com.trees;

import com.trees.LeetCode.ListNode;

import java.util.ArrayList;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode()
    {

    }
    public TreeNode(int data)
    {
        this.data=data;
    }
    public TreeNode(int data, TreeNode left, TreeNode right)
    {
        this.data=data;
        this.left=left;//pointer to left Child
        this.right=right;//pointer to right Child
    }
    //convert array to a tree
    public TreeNode arrayToTree(Integer array[]) {
        return arrayToTree(array, 0);
    }
    public TreeNode arrayToTree(Integer array[], int index) {
        if (index >= array.length)
            return null;
        if (array[index] == null)
            return null;
        return new TreeNode(array[index], arrayToTree(array, index * 2 + 1), arrayToTree(array, index * 2 + 2));
    }

    TreeNode sortedArrayToBST(int nums[],int left, int right){
//        Since it is sorted if l>r, then it means that there are no more elements on that subtree
        if(left>right) return null;
//        Choose the middle as the root
        int p=(left+right)/2;
//        populate the  root from the constructor that takes data as input
        TreeNode root=new TreeNode(nums[p]);
//        recurse on the left
        root.left=sortedArrayToBST(nums,left,p-1);
//        Recurse on the right
        root.right=sortedArrayToBST(nums,p+1,right);
//        Then return the root as the new BST
        return root;
    }
    TreeNode fromListNodeToTreeNode(ListNode head)
    {
        //convert to arrayList so as to benefit from indexes
        ArrayList<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
        }
        //optional...convert to array
        int nums[]=new int[list.size()];
        for(int i=0;i<nums.length;i++){
            nums[i]=list.get(i);
        }
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public void printTree(TreeNode root)
    {
        // Function to print tree nodes in InOrder fashionif (root != null) {
        printTree(root.left);
                System.out.print(root.data + " ");
        printTree(root.right);
            }
    boolean validBST(TreeNode root, long low, long high)
    {
        if(root==null) return true; //already balanced
        if(root.data<=low || root.data>=high) return false;
        return validBST(root.left, low, root.data) && validBST(root.right,root.data, high);
    }

    //costruct binary tree from preorder traversal
//    https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root= new TreeNode( preorder[0] );

        for(int i=1;i<preorder.length;i++){
            createTree(preorder[i], root);
        }

        return root;
    }

    public TreeNode createTree(int i, TreeNode root){
        // if(root == null){
        //     root= new TreeNode(i);
        //     return root;
        // }
        if(root!=null){

            if(root.data > i){
                root.left= createTree(i, root.left);
            }

            if(root.data < i){
                root.right= createTree(i, root.right);
            }
        }
        else {
            return new TreeNode(i);
        }

        return root;
    }
}

