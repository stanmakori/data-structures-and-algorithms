package com.graphs.ImplementGraphs.leetcode;
//https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int rows=isConnected.length;
        boolean visited[]=new boolean[rows];
        int count=0;
        for(int i=0;i<rows;i++){
            if(!visited[i]){
                count++;//isConnected[i][i] == 1 meaning we have at least one city. See constraints
                dfs(isConnected, visited,i);
            }
        }
        return count;
    }
    void dfs(int isConnected[][], boolean visited[],int i){
        visited[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(!visited[j] && isConnected[i][j]==1){
                dfs(isConnected, visited,j);
            }
        }
    }
}
