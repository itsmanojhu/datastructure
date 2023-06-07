package com.ds.problemSoving.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int a[] = {12, 11, 13, 5, 6 ,14};
        Arrays.stream(a).forEach(b -> System.out.print(b +","));
        insertionSort(a);
        System.out.println();
        Arrays.stream(a).forEach(b -> System.out.print(b +","));
    }

    private static void insertionSort(int[] a) {
        for(int i=0;i<a.length-1;i++) {
            int j = i + 1;
            while (j > 0 && a[j] < a[j - 1]) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
            }

        }
    }
}
