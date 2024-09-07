package Codility.src.com.LinkedLists.Leetcode;

public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = null;
        ListNode current = head;
        while (current != null) {
            temp = current.next; //so that we do not lose it
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
