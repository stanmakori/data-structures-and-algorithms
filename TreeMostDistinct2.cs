using System;
// you can also use other imports, for example:
using System.Collections.Generic;
// you can write to stdout for debugging purposes, e.g.
// Console.WriteLine("this is a debug message");
class Solution {
    public int solution(Tree T) {
        // write your code in C# 6.0 with .NET 4.7 (Mono 6.12)
        var unique= new HashSet<int>();
        return CountDistinct(T,unique);
    }
    public static int CountDistinct(Tree T, HashSet<int>unique){
        if(T==null){
            return unique.Count;
        }
        bool isNotDuplicate = false;
        if (!unique.Contains(T.x)){
            unique.Add(T.x);
            isNotDuplicate = true;
        }
        int leftCount=CountDistinct(T.l,unique);
        int rightCount=CountDistinct(T.r,unique);
        if(isNotDuplicate)
            unique.Remove(T.x);
        return Math.Max(leftCount,rightCount);;
    }
}