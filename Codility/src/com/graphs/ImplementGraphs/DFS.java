package com.graphs.ImplementGraphs;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {
    public static String dfs(Graph g){
        String result = "";
        //Checking if the graph has no vertices
        if (g.vertices < 1){
            return result;
        }

        //Boolean Array to hold the history of visited nodes (by default-false)
        boolean[] visited = new boolean[g.vertices];

        for(int i=0; i<g.vertices; i++)
        {
            //Checking whether the node is visited or not
            if(!visited[i])
            {
                result = result + dfsVisit(g, i, visited);
            }
        }
        return result;
    }
    public static String dfsVisit(Graph g, int source, boolean[] visited) {

        String result = "";


        //Create Stack(Implemented in previous lesson) for Depth First Traversal and Push source in it
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(source);

        //Traverse while stack is not empty
        while (!stack.isEmpty()) {

            //Pop a vertex/node from stack and add it to the result
            int current_node = stack.pop();
            result += String.valueOf(current_node);

            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then push them in the stack
            LinkedList<Integer> temp = null;
            if(g.adjacencyList[current_node] !=null)
                temp = g.adjacencyList[current_node];
            Iterator<Integer> itr = g.adjacencyList[current_node].iterator();
            while (itr.hasNext()) {
                int value=itr.next();

                if (!visited[value]) {
                    stack.push(value);

                }
            }
            //Visit the node
            visited[current_node] = true;
        }//end of while
        return result;
    }
    static String dfs1(Graph g)
    {
        String dfs="";
        if(g.vertices<1) return dfs;
        boolean[] visited=new boolean[g.vertices];
        Stack<Integer> neigbors=new Stack<>();
        for(int i=0;i<g.vertices;i++)
        {
            if(!visited[i])
            {
                neigbors.push(i);
                while(!neigbors.isEmpty())
                {
                    int next=neigbors.pop();
                    dfs+=next;
                    for(int u:g.adjacencyList[next])
                    {
                        if(!visited[u])
                        {
                            neigbors.push(u);
                            visited[u]=true;
                        }
                    }
                }
            }
        }
        return dfs;

    }
    public static void main(String args[]) {

        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println("DFS traversal of Graph1 : " + dfs1(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
        System.out.println("DFS traversal of Graph2 : " + dfs1(g2));
    }
}