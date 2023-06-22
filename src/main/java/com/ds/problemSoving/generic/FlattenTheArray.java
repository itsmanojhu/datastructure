package com.ds.problemSoving.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenTheArray {
    public static void main(String[] args) {
       // int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        Object o[] = {1, 2, new Object[]{3, new Object[]{4, 5, 6},7},8};
        //Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };
        //flattenUsingJava8(a);
        //flattenUsingLoop(a);
        List b = new ArrayList();
        b.addAll(flattenUsingRecursion(o));
        System.out.println(b);
    }

    private static List flattenUsingRecursion(Object[] array) {
        List<Integer> list = new ArrayList<>();
        for(Object a: array){
            if(a instanceof Integer){
                list.add((Integer) a);
            } else if (a instanceof Object[]){
                list.addAll(flattenUsingRecursion((Object[])a));
            }
        }
        return list;
    }

    private static void flattenUsingLoop(int[][] a) {
        List result = new ArrayList();
        for(int[] b:a){
            for(int i=0;i<b.length;i++){
                result.add(b[i]);
            }
        }
        result.forEach(System.out::print);
    }

    private static void flattenUsingJava8(int[][] a) {
        int[] list = Arrays.stream(a)
                .flatMapToInt(Arrays::stream).toArray();
        Arrays.stream(list).forEach(System.out::print);
    }
}
