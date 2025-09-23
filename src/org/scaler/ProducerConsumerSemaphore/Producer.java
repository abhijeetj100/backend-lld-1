package org.scaler.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore){
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true){
//            synchronized (store){
                try {
                    producerSemaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                if(store.getItems().size() < store.getMaxSize()){ // no need to check for size since we are using semaphores now.
                    store.addItem();
                consumerSemaphore.release();
//                }
//            }
        }
    }
}
