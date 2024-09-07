package com.LinkedLists.Leetcode;

import com.trees.LeetCode.ListNode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class RemoveListDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;//point to the next one. Think of 1,1,1,1,1. skips 4 times
            } else {
                current = current.next;//current node's next listNode is this new unique one
            }
        }
        return head;
    }
}
