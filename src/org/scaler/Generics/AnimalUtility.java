package org.scaler.Generics;

import java.util.List;

public class AnimalUtility {
    public static void printAnimalNames(List<Animal> animals){
        for(Animal animal : animals){
            System.out.println(animal.name);
        }
    }

    public static void printNames(List<? extends Animal> animals){
        System.out.println(animals);
    }

//    public static <T> void printNamesRaw(List<T> list){
////        list.add(new Object());
//        for(T item : list){
//            System.out.println(item);
//        }
//    }

    // Generic Method, accepts any type that is a subclass of Animal or Animal itself.
//    public static <T extends Animal> void printNames(List<T> animals){
////        animals.add(new T("d"));
////        animals.add(new Animal("A"));
//        for(T animal : animals){
//            System.out.println(animal.name);
//        }
//    }
}
