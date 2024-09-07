package Codility.src.com.trees.LeetCode;

import com.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    //    using a queue for level order traversal
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> currentNodes = new LinkedList<>();
        //add the root node
        currentNodes.offer(root);
        int maxDepthSoFar = 0;
        while (!currentNodes.isEmpty()) {
            int currentSize = currentNodes.size();
            maxDepthSoFar++;
            for (int i = 0; i < currentSize; i++) {
                TreeNode currentNode = currentNodes.poll();
                //process left and right subtrees
                if (currentNode.left != null) {
                    currentNodes.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    currentNodes.offer(currentNode.right);
                }
            }
        }
        return maxDepthSoFar;
    }
}
