package com.graphs.ImplementGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBasics {
    void offerDemo() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(2);
        System.out.println(q);
    }
    public static void main(String[] args)
    {
        new QueueBasics().offerDemo();
    }
}
