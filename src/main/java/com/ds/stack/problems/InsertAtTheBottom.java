package com.ds.stack.problems;

import com.ds.stack.implementation.StackUsingLinkedList;

public class InsertAtTheBottom {

    public static void main(String[] args) {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        pushAtTheBottomUsingRecursion(stack,0);

        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    private static void pushAtTheBottomUsingRecursion(StackUsingLinkedList<Integer> stack, int s) {
        if(stack.size()==0){
            stack.push(s);
            return;
        }
        int i = stack.pop();
        pushAtTheBottomUsingRecursion(stack,s);
        stack.push(i);
    }
}
