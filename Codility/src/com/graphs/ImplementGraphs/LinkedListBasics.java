package com.graphs.ImplementGraphs;
import java.util.*;
public class LinkedListBasics {
//    As an array
    void linkedListAsArray()
    {
//        LinkedList[] list=new LinkedList[];//cant compile because it needs to be parametarized, like arrays
        LinkedList[] list=new LinkedList[6];
        for(int i=0;i<list.length;i++)
        {
            list[i]=new LinkedList();
        }
        System.out.println(Arrays.toString(list));

    }
    void basicOperations()
    {
        Deque<Integer> dq=new LinkedList<>();
        dq.add(0);
        dq.add(2);
        dq.addFirst(-1);
        dq.addLast(5);
        System.out.println(dq);
    }
    void asArray()
    {
        LinkedList<Integer> list[]=new LinkedList[2];
        for(int i=0;i<2;i++)//without this, it will throw nullpointerEsception in  the add operation below
        {
            list[i]=new LinkedList<>();//they need to be initialized to empty arrays
        }
        list[0].addLast(1);
        list[1].addFirst(2);
        System.out.println(Arrays.toString(list));


    }
    public static void main(String[] args)
    {
        new LinkedListBasics().asArray();

    }
}
