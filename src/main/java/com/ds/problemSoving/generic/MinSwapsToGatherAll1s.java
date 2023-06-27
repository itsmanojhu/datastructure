package com.ds.problemSoving.generic;

import java.util.Arrays;

public class MinSwapsToGatherAll1s {
    public static void main(String[] args) {
        int case1[] = {1,1,1,1,0,1,0,1,0};//1
        int case2[] ={1,0,0,1,0,1,1,0,1,1};//2
        int case3[] ={0,0,1,1,0,1,0,0,0,1,1};//2

        gatherAll1(case1);
        gatherAll1(case2);
        gatherAll1(case3);
    }

    private static void gatherAll1(int[] a) {
        int totalsOnes = Arrays.stream(a).sum();
        int firstOnes =0;
        for(int i=0;i<totalsOnes;i++){
            if(a[i]==1)
                firstOnes++;
        }

        int maxOnes = firstOnes;

        for(int i=1;i<a.length-totalsOnes;i++) {
            if (a[i - 1] == 1)
                firstOnes--;
            if (a[i + firstOnes -1] == 1)
                firstOnes++;

            if (maxOnes < firstOnes)
                maxOnes = firstOnes;
        }

        System.out.println(totalsOnes-maxOnes);
    }

}
