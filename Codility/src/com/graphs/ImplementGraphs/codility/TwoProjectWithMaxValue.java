package com.graphs.ImplementGraphs.codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoProjectWithMaxValue {
    public int solution(int[] V, int[] A, int[] B) {
        Map<Integer, ArrayList<Integer>> adjList = buildAdjList(A, B, V.length);
        List<Integer> noDependencies = new ArrayList<>();
        int maxPair = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> project : adjList.entrySet())
        {
            // if project has no dependancies and a positive value
            // save to list of projects with no dependancies
            Integer key=project.getKey();
            ArrayList<Integer> value=project.getValue();
            if (value.size() == 0 && V[key] >= 0)
                noDependencies.add(V[key]);
                // if the project has one and only one dependancy check if the sum of
                // two project is larger than the maxPair recorded so far
            else if (value.size() == 1)
            {
                Integer dependacy = value.get(0);
                if (adjList.get(dependacy).size() == 0)
                    maxPair = Math.max(maxPair, V[key]+V[dependacy]);
            }
        }
        // Check if two project without dependancies have a greater value
        // than the maxPair recorded
        int n = noDependencies.size();
        //noDependencies;
        if (n == 1)
            return Math.max(noDependencies.get(0), maxPair);
        else if (n > 1)
            return Math.max(noDependencies.get(n-1)+noDependencies.get(n-2), maxPair);
        return maxPair;
    }
    public Map<Integer, ArrayList<Integer>> buildAdjList (int[] A, int[] B, int N)
    {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < N; i++)
            adjList.put(i, new ArrayList<Integer>());
        for (int i = 0; i < A.length; i++) {
//            adjList.get([B[i]]).put(A[i]);
            adjList.get(B[i]).add(A[i]);
        }
        return adjList;
    }
}
