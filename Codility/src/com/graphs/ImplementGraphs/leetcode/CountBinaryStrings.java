package com.graphs.ImplementGraphs.leetcode;
//https://leetcode.com/problems/count-binary-substrings/description/
public class CountBinaryStrings {
    //my solution. Working but not optimal
    public int countBinarySubstrings(String s) {
        int count=0;
        int lp=0;
        int rp=s.length();
        char c=s.charAt(0);
        int i=lp;
        while(i<rp){
            int curr=0;
            if(s.charAt(i)!=s.charAt(lp))
            {
                count += Math.min(leftDFS(s, i-1, s.charAt(i-1)),rightDFS(s, i, s.charAt(i)) );
                lp=i;
            }
            i++;

        }
        return count;

    }
    int leftDFS(String s, int index, char c){
        int count=0;
        while(index>=0)
        {

            if(s.charAt(index) !=c){
                break;
            }
            count++;

            index--;
        }
        return count;
    }
    int rightDFS(String s, int index,char c){
        int count=0;
        while(index<s.length())
        {

            if(s.charAt(index) !=c){
                break;
            }
            count++;
            index++;

        }
        return count;
    }
}
