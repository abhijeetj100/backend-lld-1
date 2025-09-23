package org.scaler.Generics;

public class Client {
    public static void main(String[] args) {
        Pair<Double, Double> p = new Pair<>(123.46, 234.56);
        p.printPair();
//        p.first = "AJ"; // Error: incompatible types: String cannot be converted to Double

        Pair<String, Double> pop = new Pair<>("India", 123.45);
        pop.printPair();
    }
}
