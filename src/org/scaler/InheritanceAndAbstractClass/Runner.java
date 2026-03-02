package org.scaler.InheritanceAndAbstractClass;

public interface Runner {
    default void Run(){
        System.out.println("Entity if Running");
    };
    default int getCurrentAge(){
        return x;
    }
    static void printX(Runner r){
        System.out.println("Age: " + r.getCurrentAge());
    }
    int x = 5;
}
