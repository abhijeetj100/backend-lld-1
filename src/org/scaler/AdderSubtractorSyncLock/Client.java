package org.scaler.AdderSubtractorSyncLock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value v = new Value();

        Adder a = new Adder(v);
        Subtractor s = new Subtractor(v);

        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Void> adderFuture = es.submit(a);
        Future<Void> subtractorFuture = es.submit(s);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(v.value);

        es.shutdown();

    }
}
