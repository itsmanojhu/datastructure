package com.ds.problemSoving.generic;

public class AllCombinationOfString {
    static StringBuilder output = new StringBuilder();
    static String str = "ABC";
    public static void main(String[] args) {
        printAllCombination(str,str.length());
    }

    private static void printAllCombination(String str, int length) {
        for(int i=0;i<length;i++){
            for(int j=i+1;j<=length;j++){
                System.out.println(str.substring(i,j));
            }
        }
    }

}
