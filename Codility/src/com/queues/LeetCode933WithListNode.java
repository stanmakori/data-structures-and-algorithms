package Codility.src.com.queues;

public class LeetCode933WithListNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    class RecentCounter {
        ListNode head;
        ListNode tail;
        int count;

        public RecentCounter() {
            head = null;
            tail = null;
            count = 0;
        }

        public int ping(int t) {
            ListNode newNode = new ListNode(t);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            while (head != null && t - head.val > 3000) {
                head = head.next;
                count--;
            }

            count++;
            return count;
        }
    }
}
