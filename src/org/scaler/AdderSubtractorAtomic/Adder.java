package org.scaler.AdderSubtractorAtomic;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value v;

    Adder(Value v){
        this.v = v;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i<=1000; i++){
                System.out.println("Adding: " + i);
                this.v.value.addAndGet(i);
        }

        return null;
    }
}
