package com.ds.problemSoving.generic;

public class MaxSumExcludingAdjacentNum {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 0, 6,9};
        //new int[]{1, 3, 6,3, 10, 2, 1,5};
        sum(arr);
    }
    private static void sum(int[] a) {
       int max=0,current=a[0],prev=0;

       for(int b: a){
           max = Math.max(current, prev);
           current = prev + b;
           prev =max;
       }

        System.out.println(Math.max(current, prev));
    }
}
