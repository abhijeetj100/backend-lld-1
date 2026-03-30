package org.scaler.Generics;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
//        Pair<Double, Double> p = new Pair<>(123.46, 234.56);
//        p.printPair();
////        p.first = "AJ"; // Error: incompatible types: String cannot be converted to Double
//
//        Pair<String, Double> pop = new Pair<>("India", 123.45);
//        pop.printPair();

        List<Dog> dogs = new ArrayList<>();
//        dogs.add(new Animal("Dog 1"));
        dogs.add(new Dog("Tobby"));
        dogs.add(new Dog("Tommy"));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Tom"));
        animals.add(new Dog("Tom1"));
        animals.add(new Animal("Human"));

        AnimalUtility.printAnimalNames(animals);

//        AnimalUtility.printAnimalNames(dogs); // invalid inheritance using Generics


    }
}
