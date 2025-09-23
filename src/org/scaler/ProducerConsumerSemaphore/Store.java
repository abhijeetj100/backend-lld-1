package org.scaler.ProducerConsumerSemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Store {
    private int maxSize;
//    private List<Object> items;
    private ConcurrentLinkedDeque<Object> items;// handles multithreaded, thread-safe operations.
    Store(int maxSize){
        this.maxSize = maxSize;
//        this.items = new ArrayList<>();
        this.items = new ConcurrentLinkedDeque<>();
    }

    public ConcurrentLinkedDeque<Object> getItems() {
        return items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void addItem() {
        System.out.println("Producer production time, current size "+this.items.size());
        this.items.add(new Object());
    }

    public void removeItem(){
        System.out.println("Consumer consumption time, current size "+this.items.size());
//        this.items.remove(this.items.size()-1);
//        this.items.removeLast();
        this.items.remove(); // removes the last by default
    }
}
