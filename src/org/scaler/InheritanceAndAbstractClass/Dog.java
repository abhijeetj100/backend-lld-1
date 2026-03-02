package org.scaler.InheritanceAndAbstractClass;

public class Dog implements Runner{
//    Runner.x = 10;
    // this is just for a sanity check during compilation
    // that we intend to override the methods from
    // the interface Runner and not create a new one.
    @Override
    public void Run(){
        System.out.println("Dog is running: "+ Runner.x);
    }

    @Override
    public int getCurrentAge(){
        return 10;
    }
}
