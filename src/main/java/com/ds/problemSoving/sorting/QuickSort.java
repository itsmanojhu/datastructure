package com.ds.problemSoving.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int a[] = {12, 11, 13, 5, 6 ,14,1};
        Arrays.stream(a).forEach(b -> System.out.print(b +","));
        quickSort(a, 0, a.length-1);
        System.out.println();
        Arrays.stream(a).forEach(b -> System.out.print(b +","));
    }

    private static void quickSort(int[] a, int low, int high) {
        if(low<high){
            int pi = partition(a,low, high);

            quickSort(a, low, pi-1);
            quickSort(a, pi+1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low-1;

        for(int j=low;j<high;j++){
            if(a[j]<pivot){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++;
        int temp = a[i];
        a[i] = a[high];
        a[high] = temp;
        return i;
    }
}
