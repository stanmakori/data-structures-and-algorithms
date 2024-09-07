using System;
using System.Collections.Generic;
// you can also use other imports, for example:
// using System.Collections.Generic;

// you can write to stdout for debugging purposes, e.g.
// Console.WriteLine("this is a debug message");

class Solution {
    public int solution(Tree T) {
        // write your code in C# 6.0 with .NET 4.7 (Mono 6.12)

        var dict= new Dictionary<int,int>();
        return Util(T,dict);
    }

    public static int Util(Tree T, Dictionary<int, int>paths){
        if(T==null){
            return paths.Count;
        }
        if(!paths.ContainsKey(T.x)){
            paths.Add(T.x,1);
        }else{
            paths[T.x]=paths[T.x]+1;
        }
        int leftCount=Util(T.l,paths);
        int rightCount=Util(T.r, paths);

        if(paths.ContainsKey(T.x)){
            paths[T.x]=paths[T.x]-1;
        }
        if(paths[T.x]==0){
            paths.Remove(T.x);
        }
        return Math.Max(leftCount,rightCount);
    }

}