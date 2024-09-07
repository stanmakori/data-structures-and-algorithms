package com.oop.ObjectComparison;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ConSuper implements Runnable{
    /**
     *
     */
    @Override
    public void run() {

    }
    protected ConSuper() {
        this(2);
        System.out.print(" 1");
    }

    protected ConSuper(int a) {
        System.out.print(" "+a);
    }
}

class ConSub extends  ConSuper{
    ConSub(){
        this(4);
        System.out.print(" 3");
    }
    ConSub(int a){
        System.out.print(" "+a);
    }

}
public class Runnables {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        for(int i = 0 ; i< 1000 ; i++){
            System.out.println();
            es.submit(new ConSub(4)).get();//always same results
        }
        es.shutdown();

    }
}
