package com.LinkedLists.Leetcode;

import com.trees.LeetCode.ListNode;

//https://leetcode.com/problems/reverse-linked-list/
//https://www.youtube.com/watch?v=jY-EUKXYT20
//https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/704/linked-lists/4707/
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextNode = curr.next; // first, make sure we don't lose the next node
                curr.next = prev;              // reverse the direction of the pointer
                prev = curr;                   // set the current node to prev for the next node
                curr = nextNode;               // move on
            }

            return prev;
        }
    }
