package Algorithms;

import java.util.Arrays;

/**
 * Created by Fuad Hasbun on 5/27/2017.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] unsorted = {3, 5, 58, 93, 9, 0, 4, 29};
        sort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

    /**
     * This method does the sorting
     * @param arr
     */
    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                int exchange = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = exchange;
            }
        }
    }
}
