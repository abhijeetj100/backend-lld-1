package org.scaler.DesignPatterns.PrototypeAndRegistry;

// in JAVA there is already an interface Cloneable,
// but just implementing for learning purpose
public interface Prototype <T>{
    public T copy();
}
