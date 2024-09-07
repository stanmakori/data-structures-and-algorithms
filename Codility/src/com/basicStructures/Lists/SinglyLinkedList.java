package com.basicStructures.Lists;

public class SinglyLinkedList {
    private static class ListNode
    {
        int data;
        ListNode next;

        ListNode(int data){
            this.data=data;
            this.next=null;//points to null by default
        }
        ListNode()
        {

        }
        ListNode(int data, ListNode next){
            this.next=next;//points to null by default
            this.data=data;
        }
    }
    //my own..neewd verification
    public ListNode createNode(ListNode node){
        ListNode head=node;
        ListNode currNode=new ListNode(node.data+1);
        int first=node.data;
        int last=first+6;
        int i=first+1;
         head.next=currNode;
        while(i<last){
            //System.out.println(i);
            ListNode child=new ListNode(i);
            currNode.next=child;
            currNode=currNode.next;//or below and is compulsory logically
            //currNode=child;//without this , it cannot iterate next, it will just print tge last element.
            i++;
        }
//        ListNode second =new ListNode(++first);
//        ListNode third=new ListNode(++first);
//        ListNode fourth=new ListNode(++first);
//        ListNode firth=new ListNode(++first);
//        node.next=second;
//        second.next=third;
//        third.next=fourth;
//        fourth.next=firth;

        //print them
        while(head!=null){
            System.out.print(head.data+"=>");
            head=head.next;
        }
        return node;
    }
    public int findLength(ListNode node){
        ListNode head=node;
        ListNode currNode=new ListNode(node.data+1);
        int first=node.data;
        int last=first+6;
        int i=first+2;
        head.next=currNode;
        while(i<last){
            //System.out.println(i);
            ListNode child=new ListNode(i);
            currNode.next=child;
            currNode=currNode.next;//or below and is compulsory logically
            //currNode=child;//without this , it cannot iterate next, it will just print tge last element.
            i++;
        }

        //print them
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args){
//        System.out.println(new SinglyLinkedList().createNode(new ListNode(1)));
        new SinglyLinkedList().createNode(new ListNode(1));
        new SinglyLinkedList().findLength(new ListNode(1));
    }

}
