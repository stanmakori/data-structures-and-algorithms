using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;

// you can write to stdout for debugging purposes, e.g.
// Console.WriteLine("this is a debug message");

class Solution {
    public int solution(int N, int[] A, int[] B) {
        // write your code in C# 6.0 with .NET 4.5 (Mono)

        Dictionary<int, HashSet<int>> adjList = BuildAdjacencyList(A, B, N);
        int seconds = 0; 
        Queue<int> toDelete = new Queue<int>();
        HashSet<int> queuedNodes = new HashSet<int>(); 
        
        // Queue all nodes that are to be deleted/disappeared in the first second
        foreach (var node in adjList)
        {
            if (node.Value.Count <= 1)
            {
                toDelete.Enqueue(node.Key);
                queuedNodes.Add(node.Key);
            }
        }

        // While there are nodes to be deleted (BFS)
        while (toDelete.Any())
        {
            // Count the number of nodes in the queue (all will be removed in the current second)
            // Any added in the for loop will the deleted/disappeared in the next second
            seconds++; 
            int roundLength = toDelete.Count; 
            
            for (int i = 0; i < roundLength; i++)
            {
                // Dequeue the next node
                int node = toDelete.Dequeue();

                // If the node has no connections remove it
                if (adjList[node].Count == 0)
                    adjList.Remove(node);
                else
                {
                    // If the node has a connection remove it from the adjacency list of the connected node
                    foreach (int nodeOther in adjList[node])
                    {
                        adjList[nodeOther].Remove(node);
                        // If the connected node now has only one neighbour then queue it
                        if (adjList[nodeOther].Count <= 1 && !queuedNodes.Contains(nodeOther))
                        {
                            toDelete.Enqueue(nodeOther);
                            queuedNodes.Add(nodeOther);
                        }
                    }
                }
            }   
        }

        // If the graph had only nodes with no connections that could be deleted increment 
        // the second counter
        if (seconds == 0 && adjList.Count < N)
            return 1;

        return seconds;
    }


    public Dictionary<int, HashSet<int>> BuildAdjacencyList (int[] A, int[] B, int N){

        Dictionary<int, HashSet<int>> adjList = new Dictionary<int, HashSet<int>> ();

        for (int i = 0; i < A.Length; i++)
        {
            if(!adjList.ContainsKey(A[i]))
                adjList.Add(A[i], new HashSet<int>());
            adjList[A[i]].Add(B[i]);
        }

        for (int i = 0; i < B.Length; i++)
        {
            if(!adjList.ContainsKey(B[i]))
                adjList.Add(B[i], new HashSet<int>());
            adjList[B[i]].Add(A[i]);
        }
        //printAdj(adjList);
        
        return adjList;
    }
}