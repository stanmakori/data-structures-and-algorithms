package Codility.src.com.LinkedLists;

public class SinglyLinkedList {
    public ListNode addNode(ListNode node, int val) {
        if (node == null) { //if node is null then  return  null    instead
            return new ListNode(val);
        }
        ListNode newNode = new ListNode(val);
        ListNode current = node;
        while (current != null) {
            current     = current.next;
        }
        current.next = newNode;
        return node;
    }
    ListNode addNodeAtIndex(ListNode node, int index, int value) {
//        edge case 1: head is null. Just return the new node
        ListNode newNode = new ListNode(value);
        if (node == null) {
            return newNode;
        }
//        edge case 2. inserting at index 0
        if (index == 0) {
            newNode.next = node;
            node = newNode;
            return node;
        }
        ListNode current = node;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        newNode.next = current.next;
        current.next = newNode;
        return node;
    }
}
