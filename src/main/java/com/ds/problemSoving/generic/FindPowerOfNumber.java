package com.ds.problemSoving.generic;

public class FindPowerOfNumber {
    public static void main(String[] args) {
        int num = 2;
        int pow = 6;
        System.out.println(printPowerOfNum(num, pow));
    }

    private static int printPowerOfNum(int num, int pow) {
        if(pow == 0)
            return 1;
        int sum = 1;
        for(int i=1;i<=pow;i++){
            sum = sum * num;
        }
        return sum;
    }
}
