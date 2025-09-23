package org.scaler.AddSubtractorLock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value v;
    private Lock lock;

    Subtractor(Value v, Lock lock){
        this.v = v;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        lock.lock();
        for(int i = 1; i<=1000; i++){
//            lock.lock();
            System.out.println("Subtracting: " + i);
            v.value = v.value - i;
//            lock.unlock();
        }
        lock.unlock();
        return null;
    }
}
