package org.scaler.AdderSubtractorDeadlock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Lock lock2;
    private Lock lock1;
    private Value v;

    Adder(Value v, Lock lock1, Lock lock2){
        this.v = v;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i<=1000; i++){
            lock2.lock();
            lock1.lock();
                System.out.println("Adding: " + i);
                v.value = v.value + i;
                lock2.unlock();
                lock1.unlock();
        }

        return null;
    }
}
