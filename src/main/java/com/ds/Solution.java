package com.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static String str = "abc";
    public static void main(String[] args) {
        int a[] = {12, 11, 13, 5, 6 ,14,1,1};
        //int a[] = {1,4,2,2,2,5,5,5,2,2,2,1,2,2,2};
        System.out.println(totalFruit(a));
    }

    private static int totalFruit(int[] a) {
        int t1 = a[0], t2=-1,t1Count=1,t2Count=1,maxCount=1;
        for(int i=1;i<a.length;i++){
            if(a[i] == t1){
                t1Count++;
                t2Count++;
            } else if(a[i] == t2){
                t2=t1;
                t1 = a[i];
                t1Count++;
                t2Count=1;
            } else if(a[i] != t1 && a[i] != t2){
                maxCount = Math.max(maxCount,t1Count);
                t1Count=t2Count+1;
                t2Count=1;
                t2 = t1;
                t1 = a[i];
            }
        }
        return Math.max(maxCount,t1Count);
    }

    private static void printAllCombination(int start) {
        for(int i = start;i<str.length();i++){
            sb.append(str.charAt(i));
            System.out.println(sb);
            if(i<str.length()){
                printAllCombination(i+1);
            }
            sb.setLength(sb.length()-1);
        }
    }

    private static void printAllPermutation(String str, String ans, List<String> list) {
        if(str.equals("")){
            list.add(ans);
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String ros = str.substring(0,i) + str.substring(i+1);
            printAllPermutation(ros, ans+ch, list);
        }
    }

    private static int binarySearch(int[] a, int low, int high, int n) {
        if(low<=high) {
            int mid = low + (high - low) / 2;

            if (a[mid] > n) {
                return binarySearch(a, low, mid - 1, n);
            } else if (a[mid] < n) {
                return binarySearch(a, mid + 1, high, n);
            } else if(a[mid] == n) {
                return mid;
            }
        }
        return -1;
    }

    private static void quickSort(int[] a, int low, int high) {
        if(low<high){
            int pivot = partition(a, low, high);

            quickSort(a,low,pivot-1);
            quickSort(a,pivot+1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int ref = a[high];
        int i = low-1;

        for(int j=low;j<high;j++){
            if(a[j]<ref){
                i++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        i++;
        int temp = a[high];
        a[high] = a[i];
        a[i] = temp;
        return i;
    }

    private static int[] mergeSort(int[] a) {
        if (a.length < 2)
            return a;
        int mid = a.length / 2;
        int left[] = new int[mid];
        int right[];
        if (a.length % 2 == 0) {
            right = new int[mid];
        } else {
            right = new int[mid + 1];
        }

        for(int i=0;i<left.length;i++){
            left[i] = a[i];
        }
        for(int i=0;i<right.length;i++){
            right[i] = a[mid+i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return mergeArray(left, right);
    }

    private static int[] mergeArray(int[] left, int[] right) {
        int result[] = new int[left.length+right.length];
        int leftPointer=0, rightPointer=0,resultPointer=0;
        while(left.length>leftPointer || right.length>rightPointer){
            if(left.length>leftPointer && right.length>rightPointer){
                if(left[leftPointer]>right[rightPointer]){
                    result[resultPointer++] = right[rightPointer++];
                } else {
                    result[resultPointer++] = left[leftPointer++];
                }
            } else if(left.length>leftPointer){
                result[resultPointer++] = left[leftPointer++];
            } else {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                   min = j;
                }
            }
            if(i != min) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }

    private static void insertionSort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            int j = i+1;

            while(j>0 && a[j]<a[j-1]){
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                --j;
            }
        }
    }

    private static void bubbleSort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }


}
