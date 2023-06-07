package com.ds.queue;

public interface QueueSkeleton<T> {
    public void enqueue(T value);
    public T dequeue();
    public boolean contains(T value);
    public int size();

    void display();
}
