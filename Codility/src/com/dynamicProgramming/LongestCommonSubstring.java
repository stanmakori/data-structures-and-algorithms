package com.dynamicProgramming;

import java.util.Arrays;

//https://www.youtube.com/watch?v=UZRkpGk943Q&t=1064s
public class LongestCommonSubstring {
    //my solution
    int dp[][];
    int longectCommonSubstring(String s1, String s2){
       dp=new int[s1.length()+1][s2.length()+1];//must be longer to acocmodate "" strings
        int max=0;
        int temp=0;
        dp[0][0]=0;
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1+lscRec(s1,s2,i, j);
                    max=Math.max(max, dp[i][j]);
                }
            }
        }
    return max;
    }
    String lcsubstring(String s1, String s2){
        if(s1.length()==0 || s2.length()==0) return "";
        dp=new int[s1.length()+1][s2.length()+1];//must be longer to acocmodate "" strings
        int max=0;
        int temp=0;
        dp[0][0]=0;
        int lastIndex=0;
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1+lscRec(s1,s2,i, j);
                    if(dp[i][j]>max){
                        max=dp[i][j];
                        lastIndex=j;

                    }
                }
            }
        }
        //below not accurate
//        if(s1.length()==s2.length()){
//            return s2.substring((lastIndex-max)+1,lastIndex+1);
//        }
//        else
//        {
            return s2.substring(lastIndex+1-max,lastIndex+1);
//        }

    }
    //generate the actual string

    int lscRec(String s1, String s2,int l1, int l2){
        //base case
        if(l1>=s1.length() || l2>=s2.length() || l1<=0 || l2<=0 ){
            return 0;
        }
        //return value of previous row left column
        return dp[l1-1][l2-1];
    }
    public static void main(String[] args){
//        String s1="ABCDGH";
//        String s2="ACDGHR";
////        System.out.println(new LongestCommonSubstring().longectCommonSubstring(s1,s2));
//        System.out.println(new LongestCommonSubstring().longectCommonSubstringString(s1,s2));
//        String s3="evanson";
//        String s4="devan";
//        System.out.println(new LongestCommonSubstring().longectCommonSubstringString(s3,s4));
//        s3="sendora";
//        s4="ondora";
//        System.out.println(new LongestCommonSubstring().longectCommonSubstringString(s3,s4));
        //case 2
        String s1="ABCDGH";
        String s2="ACDGHRSTU";
//        System.out.println(new LongestCommonSubstring().longectCommonSubstring(s1,s2));
        System.out.println(new LongestCommonSubstring().lcsubstring(s1,s2));
        String s3="evanson";
        String s4="devan";
        System.out.println(new LongestCommonSubstring().lcsubstring(s3,s4));
        s3="sendora";
        s4="ondora";
        System.out.println(new LongestCommonSubstring().lcsubstring(s3,s4));
        String s5="Onkangi";
        String s6="";
        System.out.println(new LongestCommonSubstring().lcsubstring(s5,s6));
        String s7="fghiabcd";
        String s8="abc";
        System.out.println(new LongestCommonSubstring().lcsubstring(s7,s8));
    }
}
