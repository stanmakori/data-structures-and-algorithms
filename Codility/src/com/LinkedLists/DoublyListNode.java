package Codility.src.com.LinkedLists;

public class DoublyListNode {
        int val;
        DoublyListNode next;
        DoublyListNode prev;
        DoublyListNode(int val) {
            this.val = val;
        }
    void addNode(DoublyListNode node, DoublyListNode nodeToAdd) {
        DoublyListNode prevNode = node.prev;
        nodeToAdd.next = node;
        nodeToAdd.prev = prevNode;
        prevNode.next = nodeToAdd;
        node.prev = nodeToAdd;
    }

    void deleteNode(DoublyListNode node) {
        DoublyListNode prevNode = node.prev;
        DoublyListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
