package com.ds.problemSoving.generic;

import java.util.HashMap;
import java.util.Scanner;

public class FrequencyOfEachCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        findFrequency(word);
    }

    private static void findFrequency(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<word.length();i++){
            if(map.containsKey(word.charAt(i))){
                map.put(word.charAt(i), map.get(word.charAt(i))+1);
            } else {
                map.put(word.charAt(i), 1);
            }
        }
        map.forEach((k,v) -> System.out.println(k + "  " + v));
    }
}
