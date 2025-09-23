package org.scaler.AdderSubtractorAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Value {
//    public int value = 0;
    // handles concurrent updates like adds/subtracts in a thread-safe manner.
    public AtomicInteger value = new AtomicInteger(0);

}
