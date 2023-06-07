package com.ds.stack.problems;

import com.ds.stack.implementation.StackUsingArray;

import java.util.Arrays;

public class ReverseString {

    public static void reverseUsingStream(StackUsingArray<String> stack){
        String result = "";
        while(stack.size()>0){
            result = result.concat(stack.pop());
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        StackUsingArray<String> stack = new StackUsingArray<>(10);
        String str = "Manoj";
        Arrays.stream(str.split("")).forEach(s->stack.push(s));
        //reverseUsingStream(stack);
        //addAtTheBottom(stack,"K");
        reverseUsingRecursion(stack);

        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    private static void addAtTheBottom(StackUsingArray<String> stack, String k) {
        if(stack.size()==0){
            stack.push(k);
            return;
        }
        String s = stack.pop();
        addAtTheBottom(stack,k);
        stack.push(s);
    }

    private static void reverseUsingRecursion(StackUsingArray<String> stack) {
        if(stack.size()==0){
            return;
        }
        String s = stack.pop();
        reverseUsingRecursion(stack);
        addAtTheBottom(stack,s);
    }
}
