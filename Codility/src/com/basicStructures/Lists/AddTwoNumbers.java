package com.basicStructures.Lists;

//https://leetcode.com/problems/add-two-numbers/description/
//https://github.com/Eric-programming/CodeSolution/blob/master/src/Backtracking/Subset/Subset2.java
//https://github.com/Eric-programming/CodeSolution/blob/master/src/Backtracking/Subset/Subset1.java
import com.trees.LeetCode.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode head=result;//holds the entire list
        int val1=0,sum=0,val2=0;
        int rem=0;
        while(l1!=null || l2!=null){
            val1=l1!=null?l1.val:0;
            val2=l2!=null?l2.val:0;

            //get sum
            sum=val1+val2+rem;
            rem=sum/10;
            sum=sum%10;//that is if you get say 13 , then we say 3 carry 1
            result.next=new ListNode(sum);
            result=result.next;

            //go next
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }
        if(rem>0){
            result.next=new ListNode(sum);//add the last one, if any
        }
    return head.next;
    }

}
