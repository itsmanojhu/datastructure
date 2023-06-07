package com.ds.stack;

public interface StackSkeleton<T> {
    void push(T data);

    T pop();

    boolean contains(T value);

    T getData(T value);

    T peek();

    int size();
}
