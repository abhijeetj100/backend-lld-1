package org.scaler.MultiThreading;

public class ValuePrinter implements Runnable{
    private int value ;
    public ValuePrinter(int value){
        this.value = value;
    }
    @Override
    public void run(){
        System.out.println(this.value);
    }
}
