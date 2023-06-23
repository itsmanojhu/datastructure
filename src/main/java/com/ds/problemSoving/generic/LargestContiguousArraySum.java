package com.ds.problemSoving.generic;

public class LargestContiguousArraySum {
    public static void main(String[] args) {
        int a[] = {-1,-2, -3, 9, -1,-5, -2, 1, 8, -3};
        int b[] = {-5,-2, -3, -9, -6,-5, -2, -3, -8, -3};
        int max = Integer.MIN_VALUE, sum=0;
        int negMax=Integer.MIN_VALUE;
        for(int i: b){
            sum = sum +i;
            if(sum>max){
                max = sum;
            } else if(sum<0){
                negMax = (sum>negMax)?sum:negMax;
                sum=0;
            }
        }
        System.out.println(Math.max(max,negMax));
    }
}
