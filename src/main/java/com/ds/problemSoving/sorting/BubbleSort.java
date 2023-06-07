package com.ds.problemSoving.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {12, 11, 13, 5, 6 ,14};
        Arrays.stream(a).forEach(b -> System.out.print(b +","));
        bubbleSort(a);
        System.out.println();
        Arrays.stream(a).forEach(b -> System.out.print(b +","));
    }

    private static void bubbleSort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    a[i] = a[i] + a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                }
            }
        }
    }
}
