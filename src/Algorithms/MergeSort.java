package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Fuad Hasbun on 5/23/2017.
 * This is an implementation of the merge sort
 * algorithm using arraylists
 */
public class MergeSort {

    private static ArrayList<Integer> aux; //auxiliary array

    public static void main(String[] args) {
        ArrayList<Integer> unsorted_arr = new ArrayList<Integer>();
        unsorted_arr.add(3141);
        unsorted_arr.add(1);
        unsorted_arr.add(3);
        unsorted_arr.add(10);
        unsorted_arr.add(3);
        unsorted_arr.add(5);
        aux_allocator(unsorted_arr);
    }

    /**
     * This method initializes the auxiliary array for the sorting
     * and starts sorting
     * @param arr array to sort
     */
    public static void aux_allocator (ArrayList<Integer> arr) {
        aux = new ArrayList<>(arr.size());
        sort(arr, 0, arr.size() - 1);
    }

    /**
     * This method sorts the array
     * @param arr
     * @param lo
     * @param hi
     */
    private static void sort(ArrayList<Integer> arr, int lo, int hi) {
        //Base case: the size is 0 or 1, meaning you are sorted!
        if (hi <= lo) return;
        else {
            int mid = lo + (hi - lo)/2;
            sort(arr, lo, mid);
            sort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }

    }

    /**
     * This method is responsible for merging/joining the arrays
     * @param arr
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(ArrayList<Integer> arr, int lo, int mid, int hi) {
        //pointers for left side and right side of array
        int i = lo, j = mid + 1;

        //Initialize aux
        if (aux.isEmpty()) {
            for (int k = 0; k < arr.size(); k++) {
                aux.add(k, 0);
            }
        }
        //Set up a copy of arr into the auxiliary arraylist
        for (int k = lo; k <= hi; k++) {
            aux.set(k, arr.get(k));
        }

        //Start merging
        for (int k = lo; k <= hi; k++) {
            //Condition where i goes past mid of arr
            //This means there are no more left elements
            //so forcefully add a right element
            if (i > mid) arr.set(k, aux.get(j++));
            //condition where j goes past hi of arr
            else if (j > hi) arr.set(k, aux.get(i++));
            //check which one is lower
            else if (aux.get(j) < aux.get(i)) arr.set(k, aux.get(j++));
            else arr.set(k, aux.get(i++));
        }
    }
}
