package org.scaler.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) {
//        approachOne();

//        approachtwo();

        approachthree();
    }



    public static void approachOne(){
        Runnable hw = new HelloWorldPrinter();
//        Runnable np = new NumberPrinter();

        Thread t1 = new Thread(hw);
//        Thread t2 = new Thread(np);

        for(int i = 1; i<=100; i++){
            Runnable vp = new ValuePrinter(i);
            Thread t3 = new Thread(vp);
            t3.start();
        }

//        t2.start();
        t1.start();
    }

    public static void approachtwo(){
        ExecutorService es = Executors.newFixedThreadPool(10);

        Runnable task1 = new HelloWorldPrinter();


        for(int i = 1; i<=1000; i++){
            Runnable task2 = new ValuePrinter(i);
            es.execute(task2);
        }
        es.execute(task1);

        es.shutdown();

    }

    public static void approachthree(){
        ExecutorService es = Executors.newCachedThreadPool();

        Runnable task1 = new HelloWorldPrinter();

//        Integer value = 10;
//
//        synchronized(value){
//
//        }


        for(int i = 1; i<=1000; i++){
            Runnable task2 = new ValuePrinter(i);
            es.execute(task2);
        }
        es.execute(task1);

        es.shutdown();

    }
}
