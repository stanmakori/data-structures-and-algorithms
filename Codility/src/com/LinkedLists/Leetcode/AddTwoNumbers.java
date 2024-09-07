package com.LinkedLists.Leetcode;

import com.trees.LeetCode.ListNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Declare a new empty ListNode
        ListNode curr = new ListNode(0);

        //declare holder of the result

        ListNode head = curr;

        //variables
        int s1 = 0 , s2 = 0 , sum = 0 , carry = 0;

        while(l1 != null || l2 != null) {

            //get current values
            s1 = l1 != null ? l1.val : 0;
            s2 = l2 != null ? l2.val : 0;

            //get carry
            sum = s1 + s2 + carry ;
            carry = sum / 10;

            curr.next =new ListNode( sum%10);

            curr = curr.next;

            //shift the pointers
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        //if you have any carry forward
        if (carry > 0) {
            curr.next = new ListNode(carry);//this can as well be 1
        }

        return head.next;

    }
}
