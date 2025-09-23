package org.scaler.ProducerConsumerProblem;

public class Consumer implements Runnable{
    private Store store;

    Consumer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            if(store.getItems().size() > 0){
                store.removeItem();
            }
        }
    }
}
