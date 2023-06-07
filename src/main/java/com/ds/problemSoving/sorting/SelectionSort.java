package com.ds.problemSoving.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int a[] = {12, 11, 13, 5, 6 ,14};
        Arrays.stream(a).forEach(b -> System.out.print(b +","));
        //selectionSort(a);
        a = mergeSort(a);
        System.out.println();
        Arrays.stream(a).forEach(b -> System.out.print(b +","));
    }

    private static int[] mergeSort(int[] a) {
        if(a.length<2)
            return a;
        
        int mid = a.length/2;
        
        int left[] = new int[mid];
        int right[] ;
        
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
        
        left=mergeSort(left);
        right=mergeSort(right);
        
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int leftPointer=0,rightPointer=0,resultPointer=0;
        int result[] = new int[left.length+right.length];

        while(left.length>leftPointer || right.length>rightPointer){
            if(left.length>leftPointer && right.length>rightPointer){
                if(left[leftPointer]>right[rightPointer]){
                    result[resultPointer++] = right[rightPointer++];
                } else {
                    result[resultPointer++] = left[leftPointer++];
                }
            } else if(left.length>leftPointer){
                result[resultPointer++] = left[leftPointer++];
            } else if(right.length>rightPointer){
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    private static void selectionSort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            int min = i;
            for(int j=i+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min = j;
                }
            }
            if(i!=min) {
                a[i] = a[i] + a[min];
                a[min] = a[i] - a[min];
                a[i] = a[i] - a[min];
            }
        }
    }
}
