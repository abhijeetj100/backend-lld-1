package org.scaler.AdderSubtractorSynchronizedMethod;

public class Value {
    public int value = 0;

    synchronized void incrementBy(int v){
        this.value = this.value + v;
    }

    synchronized void decrementBy(int v){
        this.value = this.value - v;
    }

//    Value(int v){
//        this.value = v;
//    }
}
