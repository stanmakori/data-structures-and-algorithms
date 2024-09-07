package Codility.src.com.trees.LeetCode;

import Codility.src.com.trees.traversals.TreeNode;

import java.util.*;

public class LeetCode103 {
    //    my own solution
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagList = new ArrayList<>();
        if (root == null) {
            return zigzagList;
        }
        Queue<TreeNode> currentNodes = new LinkedList<>();
        currentNodes.offer(root);
        int level = 0;
        while (!currentNodes.isEmpty()) {
            int size = currentNodes.size();
            List<Integer> currentZig = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = currentNodes.poll();
                currentZig.add(currentNode.data);
                if (currentNode.left != null) {
                    currentNodes.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    currentNodes.offer(currentNode.right);
                }
            }
            if (level % 2 == 0) {
                zigzagList.add(currentZig);
            } else {
                Collections.reverse(currentZig);
                zigzagList.add(currentZig);
            }
            level++;
        }
        return zigzagList;
    }
    //optimized one by chatgpt
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> zigzagList = new ArrayList<>();
        if(root == null) {
            return zigzagList;
        }

        Deque<TreeNode> currentNodes = new LinkedList<>();
        currentNodes.offer(root);
        int level = 0;

        while(!currentNodes.isEmpty()) {
            int size = currentNodes.size();
            List<Integer> currentZig = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = currentNodes.poll();

                if (level % 2 == 0) {
                    currentZig.add(currentNode.data);
                } else {
                    currentZig.add(0, currentNode.data); // Insert at the beginning
                }

                if (currentNode.left != null) {
                    currentNodes.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    currentNodes.offer(currentNode.right);
                }
            }
            zigzagList.add(currentZig);
            level++;
        }
        return zigzagList;
    }

}



class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currentList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current;
                if (level % 2 == 0) {
                    current = deque.pollFirst(); // For even levels, poll from the front
                } else {
                    current = deque.pollLast(); // For odd levels, poll from the end
                }
                currentList.add(current.data);

                if (level % 2 == 0) {
                    if (current.left != null)
                        deque.offerLast(current.left); // For even levels, add left child to the end
                    if (current.right != null)
                        deque.offerLast(current.right); // For even levels, add right child to the end
                } else {
                    if (current.right != null)
                        deque.offerFirst(current.right); // For odd levels, add right child to the front
                    if (current.left != null)
                        deque.offerFirst(current.left); // For odd levels, add left child to the front
                }
            }
            result.add(currentList);
            level++;
        }
        return result;
    }
}
