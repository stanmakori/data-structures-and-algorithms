package Codility.src.com.LinkedLists.Leetcode;

public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a placeHolder node to serve as the head of the merged list
        ListNode placeHolder = new ListNode(-1);
        ListNode current = placeHolder;

        // Iterate through both lists simultaneously
        while (list1 != null && list2 != null) {
            // Compare the values of the current nodes in both lists
            if (list1.val <= list2.val) {
                // Append the smaller node to the merged list
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            // Move the current pointer to the next node in the merged list
            current = current.next;
        }

        // Append the remaining nodes from list1 or list2, if any
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the head of the merged list (excluding the placeHolder node)
        return placeHolder.next;
    }
}
