package com.ds.problemSoving.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = {12, 11, 13, 5, 6 ,14};
        Arrays.stream(a).forEach(b -> System.out.print(b +","));
        mergeSort(a);
        System.out.println();
        Arrays.stream(a).forEach(b -> System.out.print(b +","));
    }

    private static int[] mergeSort(int[] a) {
        if(a.length<2)
            return a;
        int mid = a.length/2;
        int left[] = new int[mid];
        int right[];
        if(a.length%2==0){
           right = new int[mid];
        } else {
            right = new int[mid+1];
        }

        for(int i=0;i<left.length;i++){
            left[i] = a[i];
        }
        for(int i=0;i<right.length;i++){
            right[i] = a[mid+i];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        
        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        int result[] = new int [left.length+right.length];
        int leftPointer = 0,rightPointer=0,resultPointer=0;
        while(leftPointer<left.length || rightPointer<right.length){
            if(leftPointer<left.length && rightPointer<right.length){

            }
        }
        return result;
    }
}
