package com.graphs.ImplementGraphs;
import java.util.*;
public class Graph{
    public int vertices; //Total number of vertices in graph
    public LinkedList<Integer>[] adjacencyList; //An array of linked lists to store adjacent vertices.


    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        //initialize the LinkedList array, giving size=vertices
        adjacencyList = new LinkedList[vertices];//you can also this.adjacencyList=new LinkedList[vertices]

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        if (source < vertices && destination < vertices){
            this.adjacencyList[source].addLast(destination);

            //for undirected graph uncomment the line below
            //this.adjacencyList[destination].insertAtEnd(source);
        }
    }
    public void printGraph()
    {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++)
        {
            if(adjacencyList[i]!=null){
                System.out.print("|" + i + "| => ");

                Iterator<Integer> itr = adjacencyList[i].iterator();

                while (itr.hasNext())
                {
                    System.out.print("[" + itr.next() + "] -> ");
                }
                System.out.println("null");
            }
            else{

                System.out.println("|" + i + "| => "+ "null");
            }
        }
    }
    //let me see the linkedlist

}