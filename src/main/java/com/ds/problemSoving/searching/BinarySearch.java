package com.ds.problemSoving.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int a[] = {1,2,5,6,11,12,13,14};
        System.out.println(binarySearch(a, 0,a.length-1,1));
    }

    private static int binarySearch(int[] a, int low, int high, int num) {
        int mid = low + (high-low)/2;
        if(low<=high){
            if(a[mid]>num){
                return binarySearch(a,low,mid-1,num);
            } else if(a[mid]<num){
                return binarySearch(a,mid+1,high,num);
            } else if(a[mid] == num){
                return mid;
            }
        }
        return -1;
    }
}
