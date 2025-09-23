package org.scaler.AdderSubtractorDeadlock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value v;
    private Lock lock1;
    private Lock lock2;

    Subtractor(Value v, Lock lock1, Lock lock2){
        this.v = v;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i<=1000; i++){
            lock1.lock();
            lock2.lock();
                System.out.println("Subtracting: " + i);
                v.value = v.value - i;
                lock1.unlock();
                lock2.unlock();
        }
        return null;
    }
}
