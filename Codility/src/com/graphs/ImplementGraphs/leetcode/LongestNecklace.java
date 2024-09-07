package com.graphs.ImplementGraphs.leetcode;

import com.graphs.ImplementGraphs.Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//https://app.codility.com/self-register/Microsoft-Kenya-SSWE-III-Homework---Graphs-I/
public class LongestNecklace {
    public int solution(int[] A) {
        int max=0;
        if(A.length==0){return max;}
        Set<Integer> vertices=new HashSet<>();
        int count=0;
        int root=0,leaf=0;
        for(int i=0;i<A.length;i++)
        {
            count=1;
            root=i;
            leaf=A[i];
            if(!vertices.contains(root) || root==0)
            {
                vertices.add(root);
                vertices.add(leaf);
                while(leaf!=root)
                {
                    leaf=A[leaf];
                    vertices.add(leaf);
                    count++;
                }
            }
            max=Math.max(count,max);
        }

        //System.out.println(vertices);
        return max;
    }

    public static void main(String[] args)
    {
        var testArray = new int[] {5,4,0,3,1,6,2};
        System.out.println(new LongestNecklace().solution(testArray));


    }
}
