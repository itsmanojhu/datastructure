package com.ds.problemSoving.generic;

import java.util.Arrays;

public class Segregate012 {
    public static void main(String[] args) {
        int a[] = {0, 1, 0, 0, 1, 1,0,0};
        int b[] = {0, 1, 0, 0, 1, 1,0,0,1};
        int c[] = {0, 1, 0, 0, 1, 1,0,0,1,2,1,2,1,0,1};
        //segregate01(b);
        segregation012(c);
    }

    private static void segregation012(int[] a) {
        int low = 0, mid = 0, high = a.length - 1;

        while (mid <= high) {
            if (a[mid] == 0) {
                swap(a, low, mid);
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else if (a[mid] == 2) {
                swap(a, mid, high);
                high--;
            }
        }

        System.out.println(Arrays.stream(a).boxed().toList());
    }

    private static void segregate01(int[] a) {
        int low = 0, high = a.length - 1;

        while (low <= high) {
            if (a[low] == 0) {
                low++;
            } else if (a[low] == 1) {
                swap(a, low, high);
                high--;
            }
        }
        System.out.println(Arrays.stream(a).boxed().toList());
    }

    public static void swap(int a[], int b, int c){
        a[b] = a[b]+a[c];
        a[c] = a[b]-a[c];
        a[b] = a[b]-a[c];
    }
}
