package org.scaler.AdderSubtractorSynchronizedMethod;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private Value v;

    Subtractor(Value v){
        this.v = v;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i<=1000; i++){
                System.out.println("Subtracting: " + i);
                this.v.decrementBy(i);

        }
        return null;
    }
}
