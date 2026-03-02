package org.scaler.InheritanceAndAbstractClass;

public class Client {
    public static void main(String[] args) {
        Runner r1 = new Dog();
        Runner r2 = new RoboticDog();

        r1.Run();
        r2.Run();

        Runner.printX(r1);
        Runner.printX(r2);
    }
}
