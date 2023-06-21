package com.ds.problemSoving.generic;

public class AllCombinationOfString {
    static StringBuilder output = new StringBuilder();
    static String str = "ABC";
    public static void main(String[] args) {
        printAllCombination(0);
    }

    private static void printAllCombination(int start) {
        for(int i=start;i<str.length();i++) {
            output.append(str.charAt(i));
            System.out.println(output);
            if (i < str.length()) {
                printAllCombination(i + 1);
            }
            output.setLength(output.length() - 1);
        }
    }
}
