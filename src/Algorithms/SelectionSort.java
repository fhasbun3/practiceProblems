package Algorithms;

import java.util.Arrays;

/**
 * Created by Fuad Hasbun on 5/26/2017.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] unsorted = {4, 3, 8, 2, 9, 0};

        sort(unsorted);
        System.out.print("Sorted array: " + Arrays.toString(unsorted));
    }

    /**
     * This method performs the sorting
     * @param arr array to be sorted
     */
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int exchange = arr[i];
                    arr[i] = arr[j];
                    arr[j] = exchange;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }
}
