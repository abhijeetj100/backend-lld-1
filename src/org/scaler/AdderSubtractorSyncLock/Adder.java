package org.scaler.AdderSubtractorSyncLock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Value v;

    Adder(Value v){
        this.v = v;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i<=1000; i++){
            synchronized (this.v){
                System.out.println("Adding: " + i);
                v.value = v.value + i;
            }
        }

        return null;
    }
}
