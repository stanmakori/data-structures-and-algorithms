package Codility.src.com.LinkedLists.Leetcode;

public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode placeHolder = new ListNode(30);//placeholder can be anything
        placeHolder.next =head;//point to place holder here.[30] ->[head]
        ListNode slow = placeHolder;
        ListNode fast = placeHolder;
        // Move fast pointer n+1 steps ahead
        for (int i = 0; i < n ; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        // Remove the nth node from the end
        slow.next = slow.next.next;
        return placeHolder.next;// Return the head of the list

    }
}
