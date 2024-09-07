package com.graphs.ImplementGraphs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/find-if-path-exists-in-graph/
//step 1: create the grap
class Graph
{
 int vertices;//hold vertexes
 ArrayList<ArrayList<Integer>> adjacencyList=new ArrayList<>();
 Graph(int vertices,int[][] edges)
 {
     this.vertices=vertices;
     for(int i=0;i<vertices;i++)
     {
         adjacencyList.add(new ArrayList<>());
     }
     for(int edge[]: edges)
     {
         int from=edge[0];
         int to=edge[1];
         //adjacencyList[count++]=new LinkedList<>();
         adjacencyList.get(from).add(to);
         adjacencyList.get(to).add(from);
     }
 }
}
public class PathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n<1) {return false;}
        if(source==destination) {return true;}
         Graph g=new Graph(n,edges);
         //bfs
        boolean[] visited=new boolean[n];//hold visited vertices
        Queue<Integer> adj=new LinkedList<>();
        visited[source]=true;
        adj.offer(source);
                while (!adj.isEmpty())
                {
                    int current=adj.poll();
                    for(int next: g.adjacencyList.get(current))
                    {
                        if(next==destination)
                        {
                            return true;
                        }
                        if(!visited[next])
                        {
                            adj.offer(next);
                            visited[next]=true;
                        }
                    }
                }
        return false;
    }
}
