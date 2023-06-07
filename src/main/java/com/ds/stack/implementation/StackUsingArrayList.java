package com.ds.stack.implementation;

import com.ds.stack.StackSkeleton;

import java.util.ArrayList;

public class StackUsingArrayList<T> implements StackSkeleton<T> {
    ArrayList<T> list;

    public StackUsingArrayList(){
        this.list = new ArrayList<>();
    }

    public int size(){
        return this.list.size();
    }

    public void push(T value){
        list.add(value);
    }

    public T pop(){
        int index = list.size()-1;
        T value = list.remove(index);
        return value;
    }

    public boolean contains(T value){
        return list.contains(value);
    }

    @Override
    public T getData(T value) {
        while(size()>0){
            T currentData = this.list.remove(size()-1);
            if(currentData.equals(value)){
                return currentData;
            }
        }
        throw new IllegalArgumentException("Item not found. Stack is empty");
    }

    @Override
    public T peek() {
        if(size()>0){
            return this.list.get(size()-1);
        } else throw new IllegalArgumentException("Stack is Empty");
    }

    public static void main(String[] args) {
        StackUsingArrayList<Integer> stack = new StackUsingArrayList<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.size());//4
        System.out.println(stack.peek());//1
        System.out.println(stack.size());//4
        System.out.println(stack.pop());//1
        System.out.println(stack.size());//3
        System.out.println(stack.contains(3));//true
        System.out.println(stack.size());//3
        System.out.println(stack.getData(4));//1
        System.out.println(stack.size());//0

    }
}
