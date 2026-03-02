package org.scaler.InheritanceAndAbstractClass;

public class RoboticDog implements Runner{
    @Override
    public void Run(){
        System.out.println("Robotic Dog is running");
    }

    @Override
    public int getCurrentAge(){
        return 1011;
    }
}
