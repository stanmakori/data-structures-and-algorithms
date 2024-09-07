package com.oop.Abstractions;

public class Mock {
    static int edits(int nums[]){
        int count =0;
        for (int i =1 ; i < nums.length ;i++){
            if(nums[i]-nums[i-1] <2) count++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(edits(new int[]{-2,-2,-1,1,2}));
    }
}
