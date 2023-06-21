package com.ds.problemSoving.generic;

public class AllPermutationOfString {
    public static void main(String[] args) {
        String str = "abc";
        printAllSubStrings(str, "");
    }

    private static void printAllSubStrings(String str, String s) {
        if(str.equals(""))
            System.out.println(s);

        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String ros = str.substring(0,i) + str.substring(i+1);
            printAllSubStrings(ros, s+ch);
        }
    }
}
