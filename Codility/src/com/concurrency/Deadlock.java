package com.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

public class Deadlock {
    static String lock1 = "stanley";
    static String lock2 = "Makori";
    static void deadlockDemo() {
        var service = Executors.newFixedThreadPool(2);
        Future<?> f1 = service.submit( () -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println("lock2 cannot be acquired");
                }
            }
        });

        Future<?> f2 = service.submit(
                () -> {
                    synchronized (lock2) {
                        synchronized (lock1) {
                            System.out.println("lock1 cannot be acquired");
                        }
                    }
                });
    }
}
