package Codility.src.com.trees.LeetCode;

import Codility.src.com.trees.traversals.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValuePerRow = new ArrayList<>();
        if(root == null) {
            return largestValuePerRow;
        }
        Queue<TreeNode> currentNodes = new ArrayDeque<>();
        currentNodes.offer(root);
        while(!currentNodes.isEmpty()) {
            int size = currentNodes.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode currentNode = currentNodes.poll();
                max = Math.max(max, currentNode.data);
                if(currentNode.left != null) {
                    currentNodes.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    currentNodes.offer(currentNode.right);
                }
            }
            largestValuePerRow.add(max);
        }
        return largestValuePerRow;
    }
}
