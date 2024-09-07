package com.LinkedLists;

import com.trees.LeetCode.ListNode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyLinkedList {
    int val ;
    MyLinkedList next ;

    public MyLinkedList(int val, MyLinkedList next) {
        this.val = val;
        this.next = next;
    }
    public MyLinkedList(int val) {
        this.val = val;
        this.next = null;
    }
    static void readLinkedListValues() {
        MyLinkedList zero = new MyLinkedList(0, null);
        MyLinkedList one = new MyLinkedList( 1, null);
        MyLinkedList two  = new MyLinkedList(2, null);
        MyLinkedList three = new MyLinkedList(3, null);
        zero.next = one;
        one.next = two ;
        two.next = three;
        MyLinkedList head = zero;
        while (head!=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    static int sumLinkedListValues() {
        MyLinkedList zero = new MyLinkedList(0, null);
        MyLinkedList one = new MyLinkedList( 1, null);
        MyLinkedList two  = new MyLinkedList(2, null);
        MyLinkedList three = new MyLinkedList(3, null);
        zero.next = one;
        one.next = two ;
        two.next = three;
        int sum = 0;
        MyLinkedList head = zero;
        while (head!=null) {
            sum += head.val; //reda the value
//            Moving to head.next is the equivalent of iterating to the next element in an array
            head = head.next;//move pointer to the next node in the list(until it hits null)
        }
        return sum;
    }
    //or do it recursively
    int getSum(MyLinkedList head) {
        if (head == null) {
            return 0;
        }

        return head.val + getSum(head.next);
    }
    static int deleteNode(MyLinkedList head , MyLinkedList prev){
        int sum =0;
        prev .next = prev.next.next;
        int prevValue = prev.val;
        return sum;

    }
//    Find middle value - using fast and slow pointers
static int findMidddleValue() {
    MyLinkedList one = new MyLinkedList( 1);
    MyLinkedList two  = new MyLinkedList( 2);
    MyLinkedList three = new MyLinkedList( 3);
    MyLinkedList four = new MyLinkedList( 4);
    MyLinkedList five = new MyLinkedList( 5);
    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;
    five.next = null;
    int len = 0;
    MyLinkedList head = one;
    MyLinkedList dummy = head;//asig head to a dummy and iterate the dummy
    System.out.println(head.val);
    while (dummy!=null) {
        len ++; //count
//            Moving to head.next is the equivalent of iterating to the next element in an array
        dummy = dummy.next;//move pointer to the next node in the list(until it hits null)
    }

    //iterate half length
    System.out.println(head.val+ " "+len);
    for (int i = 0 ; i < len/2 ; i++){
        head = head.next;
    }
    return head.val;
}
    static int findMidddleValue1() {
        MyLinkedList one = new MyLinkedList( 1);
        MyLinkedList two  = new MyLinkedList( 2);
        MyLinkedList three = new MyLinkedList( 3);
        MyLinkedList four = new MyLinkedList( 4);
        MyLinkedList five = new MyLinkedList( 5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        MyLinkedList head = one;
        MyLinkedList slow = head;
        MyLinkedList fast = head;
        while (fast != null && fast.next != null) { //note that we work with fast pointers only
         slow = slow.next;
         fast = fast.next.next;
        }
        return slow.val;
    }
    static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
//    You can also us HashSet to detect a cycle
    public boolean detectCycle1(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }

        return false;
    }
//    Finding the kth node from the end
    static MyLinkedList kthNodeFromEnd( MyLinkedList head, int k){
//        NB: This requires tweaking fast and slow pointers. The fast pointer will be k distance
//        ahead of slow pointer. By the time the fast pointer is at the end(null) then it means that slow is
//        at k distance from the end.
        MyLinkedList slow = head ;
        MyLinkedList fast = head;

        //move fast pinter to k distance ahead
        for (int i =0 ; i< k ; i++) {
            fast = fast.next;
        }

        //now move both
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
    public static void main( String[] args) {
//        System.out.println(sumLinkedListValues());
//
//        System.out.println("===Deleting node ====");
//            MyLinkedList zero = new MyLinkedList(0, null);
//            MyLinkedList one = new MyLinkedList( 1, null);
//            MyLinkedList two  = new MyLinkedList(2, null);
//            MyLinkedList three = new MyLinkedList(3, null);
//            zero.next = one;
//            one.next = two ;
//            two.next = three;
//            MyLinkedList head = zero;
//            System.out.println(deleteNode(head, two));
        System.out.println("Middle value is "+findMidddleValue());
        System.out.println("Middle value is "+findMidddleValue1());

        }

    }
