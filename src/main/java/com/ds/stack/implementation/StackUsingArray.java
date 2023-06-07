package com.ds.stack.implementation;

import com.ds.stack.StackSkeleton;

public class StackUsingArray<T> implements StackSkeleton<T> {
    private final T[] data;
    private int stackPointer;

    public StackUsingArray(int size){
        this.data = (T[])(new Object[size]);
        this.stackPointer = 0;
    }

    @Override
    public void push(T data){
        this.data[stackPointer++] = data;
    }

    @Override
    public T pop(){
        if(this.size()>0) {
            T value = this.data[--stackPointer];
            data[stackPointer] = null;
            return value;
        } else throw new IllegalArgumentException("Stack is empty");
    }

    @Override
    public boolean contains(T value){

        for(int i=0;i<size();i++) {
            if(this.data[i].equals(value))
                return true;
        }
        return false;
    }

    @Override
    public T getData(T value){
        if(size()<=0)
            throw new IllegalArgumentException("Stack is empty");

        while(size()>0){
            T currentData = pop();
            if(currentData.equals(value)){
                return currentData;
            }
        }
        throw new IllegalArgumentException("Given value not found");
    }

    @Override
    public T peek(){
        if(size()>0){
            return this.data[stackPointer-1];
        } else throw new IllegalArgumentException("Stack is empty");
    }

    @Override
    public int size(){
        return stackPointer;
    }

    public static void main(String[] args) {
        StackUsingArray<Integer> stack = new StackUsingArray<>(10);
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
