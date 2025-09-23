package org.scaler.Generics;

public class Pair<V, S> {
    V first;
    S second;

    Pair(V first, S second){
        this.first = first;
        this.second = second;
    }

    void printPair(){
        System.out.println("First: " + first + ", Second: " + second);
    }

    void setFirst(V first){
        this.first = first;
    }

    void setSecond(S second){
        this.second = second;
    }

    V getFirst(){
        return this.first;
    }

    S getSecond(){
        return this.second;
    }
}
