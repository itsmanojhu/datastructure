package com.ds.problemSoving.generic;

public class LongestPalindromicSubstring {
    static int resultStart=0,resultLength=0;
    public static void main(String[] args) {
        String str = "Eyes".toLowerCase();
        findLongestPalindromeSubString(str);
    }

    private static void findLongestPalindromeSubString(String str) {
        if(str.length()<2) {
            System.out.println(str);
            return;
        }

        for(int start=0;start<str.length()-1;start++){
            findSubString(str, start, start);
            findSubString(str, start, start+1);
        }
        System.out.println(str.substring(resultStart, resultStart+resultLength));
    }

    private static void findSubString(String str, int start, int end) {
        while(start>=0 && end<str.length() && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
        }
        if(resultLength<end-start-1){
            resultStart = start+1;
            resultLength = end-start-1;
        }
    }
}
