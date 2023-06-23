package com.ds.problemSoving.generic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfEachWord {
    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 8, 3, 2, 2, 2, 5, 1};
        String[] str = {"Believe", "for", "good", "Believe", "for", "trust", "Believe", "forsake", "Believe",
                "Believe", "in", "you", "youtube", "Google", "for", "learning", "virtual", "data"};

        List<Integer> list = Arrays.stream(arr).boxed().toList();
        Map<String, Long> map = Arrays.stream(str).collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        map.forEach((k,v) -> System.out.println(k +"  " + v));
    }
}
