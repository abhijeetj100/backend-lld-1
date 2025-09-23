package org.scaler.ProducerConsumerProblem;

public class Producer implements Runnable{
    private Store store;

    Producer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            if(store.getItems().size() < store.getMaxSize()){
                store.addItem();
            }
        }
    }
}
