package com.ds.problemSoving.generic;

public class LongestPalindromeWordInSentence {
    public static void main(String[] args) {
        String str = "Madam Arora teaches Malayalam ";//Madddddddam
        findPalindrome(str);
    }

    private static void findPalindrome(String str) {
        String word = "", word2 = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                word = word + ch;
            } else {
                if (isPalindrome(word.toLowerCase()) && word.length() > word2.length()) {
                    word2 = word;
                }
                word = "";
            }
        }
        if (!word2.equalsIgnoreCase("")) {
            System.out.println(word2);
        }
    }

    private static boolean isPalindrome(String word) {
        for (int i=0,j=word.length()-1;i<(word.length()/2)-1;i++,j--){
            if(word.charAt(i) != word.charAt(j))
                return false;
        }
        return true;
    }
}
