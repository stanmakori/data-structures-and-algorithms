package Codility.src.com.graphs.bigraphs;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {

                queue.offer(i);
                colors[i] = 1;

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int neighbor : graph[node]) {
                        if (colors[neighbor] == 0) {
                            colors[neighbor] = -colors[node];
                            queue.offer(neighbor);
                        } else if (colors[neighbor] == colors[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
