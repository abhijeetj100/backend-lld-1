package org.scaler.TowerOfHanoi;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    static class Pair{
        int node;
        int cost;

        Pair(int n, int c){
            node = n;
            cost = c;
        }

        // Added toString so the output is readable
        @Override
        public String toString() {
            return "(" + node + ", " + cost + ")";
        }
    }
    public static void main(String[] args) {
//        moveTower(4, 'A', 'B', 'C');

        ArrayList<Pair>[] adl = new ArrayList[10];

//        for(ArrayList<Pair> row : adl){
//        }

        // 2. CRITICAL: Initialize each index with a new ArrayList
        for (int i = 0; i < adl.length; i++) {
            adl[i] = new ArrayList<>();
        }

        adl[0].add(new Pair(10, 10));

        System.out.println(Arrays.toString(adl));
    }


    public static void moveTower(int n, char source, char middle, char target){
        if(n == 0) return;

        moveTower(n-1, source, target, middle);

        System.out.println(source + " to " + target);

        moveTower(n-1, middle, source, target);




    }
}
