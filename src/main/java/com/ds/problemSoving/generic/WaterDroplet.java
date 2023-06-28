package com.ds.problemSoving.generic;

public class WaterDroplet {
    public static void main(String[] args) {
        int a[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int b[] = {0,1,0,4,0,1,1,2,2,3,1};
        findMaxDroplets(b);
    }

    private static void findMaxDroplets(int[] a) {
        int left=0,right=a.length-1,leftMax=0,rightMax=0,sum=0;

        while(left<=right){
            if(a[left]<a[right]){
                if(leftMax<a[left]){
                    leftMax=a[left];
                } else {
                    sum +=leftMax-a[left];
                }
                left++;
            } else {
                if(rightMax<a[right]){
                    rightMax = a[right];
                } else {
                    sum+=rightMax-a[right];
                }
                right--;
            }
        }
        System.out.println(sum);
    }
}
