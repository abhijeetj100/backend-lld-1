package org.scaler.MergeSortMultiThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> unsortedArray;
    private ExecutorService es;

    public Sorter(List<Integer> unsortedArray, ExecutorService es){
        this.unsortedArray = unsortedArray;
        this.es = es;
    }

    @Override
    public List<Integer> call() throws Exception{
        if(unsortedArray.size() <= 1) return unsortedArray;

        int mid = unsortedArray.size()/2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i = 0; i<mid; i++){
            left.add(unsortedArray.get(i));
        }

        for(int i = mid; i<unsortedArray.size(); i++){
            right.add(unsortedArray.get(i));
        }

        Callable<List<Integer>> leftc = new Sorter(left, this.es);
        Callable<List<Integer>> rightc = new Sorter(right, this.es);

        Future<List<Integer>> leftResult = es.submit(leftc);
        Future<List<Integer>> rightResult = es.submit(rightc);

        List<Integer> leftSorted = leftResult.get();
        List<Integer> rightSorted = rightResult.get();

        //merge

        List<Integer> sortedArray = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i<leftSorted.size() && j < rightSorted.size()){
            if(leftSorted.get(i) < rightSorted.get(j)){
                sortedArray.add(leftSorted.get(i++));
            }
            else{
                sortedArray.add(rightSorted.get(j++));
            }
        }

        while(i < leftSorted.size()){
            sortedArray.add(leftSorted.get(i++));
        }

        while(j < rightSorted.size()){
            sortedArray.add(rightSorted.get(j++));
        }

        return sortedArray;
    }
}
