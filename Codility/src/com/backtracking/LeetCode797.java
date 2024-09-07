package Codility.src.com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode797 {
    /**
     * Finds all paths from source to target in a directed acyclic graph (DAG).
     * @param graph The adjacency list representation of the graph.
     * @return List of all paths from source to target.
     * Heavily borrows from Leetcode question 46: permute
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0); // Start from node 0
        dfs(graph, 0, graph.length - 1, path, result);
        return result;
    }

    /**
     * Depth-First Search (DFS) traversal to find all paths from source to target.
     * @param graph The adjacency list representation of the graph.
     * @param node The current node being explored.
     * @param target The target node.
     * @param path The current path being explored.
     * @param result The list to store all paths from source to target.
     */
    private void dfs(int[][] graph, int node, int target, List<Integer> path, List<List<Integer>> result) {
        // If the current node is the target node, add the current path to the result
        if (node == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Explore all neighbors of the current node
        for (int neighbor : graph[node]) {
            // Add the neighbor to the current path
            path.add(neighbor);
            // Recursively explore paths starting from the neighbor
            dfs(graph, neighbor, target, path, result);
            // Backtrack: Remove the neighbor from the current path
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode797  solution = new LeetCode797 ();
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> paths = solution.allPathsSourceTarget(graph);
        System.out.println("All paths from source to target: " + paths);
    }
}
