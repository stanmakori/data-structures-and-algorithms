package com.graphs.ImplementGraphs.leetcode;

import java.util.*;

//https://leetcode.com/problems/find-if-path-exists-in-graph/description/
public class PathExists1 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //Store all edges in 'graph'.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        // Store all the nodes to be visited in 'queue'.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (currNode == destination) {
                return true;
            }

            // For all the neighbors of the current node, if we haven't visit it before,
            // add it to 'queue' and mark it as visited.
            for (int nextNode : graph.get(currNode)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }

        return false;
    }
//    You can build adjacency lists directly
    public boolean validPath1(int n, int[][] edges, int source, int destination)
    {
        //generate adjacency lists
        var adj = new ArrayList<ArrayList<Integer>> ();
        for (int i =0 ; i<n ; i++) {
            adj.add(new ArrayList<Integer>());
        }
        //populate the adj
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        //do bfs
        var seen = new boolean[n];
        var bfs = new ArrayDeque<Integer>();

        //we have seen the source
        seen[source] = true;
        bfs.offer(source);

        //bfs
        while(!bfs.isEmpty()) {
            int curr = bfs.poll();
            //if it matches dest, we hend
            if (curr == destination) return true;

            //not matching , and not seen , add it to the queue
            for (int next : adj.get(curr)) {
                if (!seen[next]) {
                    bfs.offer(next);
                    seen[next] = true;
                }
            }
        }
        return false;
    }
}
