package com.ds.queue.implementation;

import com.ds.queue.QueueSkeleton;

public class QueueUsingArray<T> implements QueueSkeleton<T> {
    private T[] data;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.data = (T[])new Object[capacity];
        this.size=0;
        this.head = -1;
        this.tail = this.capacity-1;
    }

    @Override
    public void enqueue(T value) {
        tail = (tail+1)%this.capacity;
        this.data[tail] = value;
        size++;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        else {
            head = (head+1)%this.capacity;
            T value = data[head];
            data[head] = null;
            size--;
            return value;
        }
    }

    @Override
    public boolean contains(T value) {
        if(isEmpty())
            return false;
        for(int i=0;i<size();i++){
            if(data[i] == value)
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    @Override
    public void display() {
        int index = (head+1)%this.capacity;
        for(int i =0;i<size();i++){
            System.out.println(this.data[index++]);
        }
    }

    public static void main(String[] args) {
        QueueUsingArray<Integer> queue = new QueueUsingArray<>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        queue.display();

    }
}
