package com.trees.LeetCode;

import com.trees.TreeNode;

import java.util.*;

//https://leetcode.com/problems/create-binary-tree-from-descriptions/description/
public class DecsriptionToTree {
    //my solution
    public TreeNode createBinaryTree(int[][] descriptions) {
        int len =descriptions.length;
        // General formular for balanced sorted binary tree
        // int rootValue= (len%2==1)? descriptions[(len/2)+1][0]: descriptions[(len/2)][0];
        // will not apply in this case
        // Here , the root is identified by a node that doesnt have a parent
        HashMap<Integer, TreeNode> pc=new HashMap<>();
        HashSet<Integer> children=new HashSet<>();
        for(int desc[]: descriptions){
            int parent =desc[0];
            int child =desc[1];
            int dir = desc[2];
            children.add(child);
            TreeNode node=pc.computeIfAbsent(parent, k->new TreeNode(parent));
            if(dir==1){
                node.left=pc.computeIfAbsent(child, k->new TreeNode(child));
            }
            else {
                node.right=pc.computeIfAbsent(child, k->new TreeNode(child));
            }
            pc.put(parent,node);

        }
        System.out.println(pc);
        //find root
        int root=-1;
        for(int desc[]: descriptions){
            if(!children.contains(desc[0]))
            {
                root=desc[0];
                break;
            }

        }

        //return the root
        return pc.getOrDefault(root,null);
    }

    //another solution
    public TreeNode createBinaryTree1(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] arr : descriptions) {
            int parent = arr[0], child = arr[1], isLeft = arr[2];
            children.add(child);
            TreeNode node = map.getOrDefault(parent, new TreeNode(parent));
            if (isLeft == 1) {
                node.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.left);
            } else {
                node.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.right);
            }
            map.put(parent, node);
        }

        int root = -1;
        for (int [] arr: descriptions) {
            if (!children.contains(arr[0])) {
                root = arr[0];
                break;
            }
        }
        return map.getOrDefault(root, null);
    }
}
