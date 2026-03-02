package org.scaler.MergeSortMultiThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newCachedThreadPool();

        List<Integer> ip = List.of(4, 1, 2, 3, 5, 6, 7, 4);

        Callable<List<Integer>> sorted = new Sorter(ip, es);

        Future<List<Integer>> sortedResult = es.submit(sorted);

        List<Integer> result = sortedResult.get();

        System.out.println(result);

        es.shutdown();
    }
}
