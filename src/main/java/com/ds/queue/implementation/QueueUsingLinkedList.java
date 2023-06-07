package com.ds.queue.implementation;

import com.ds.queue.QueueSkeleton;

public class QueueUsingLinkedList<T> implements QueueSkeleton<T> {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public QueueUsingLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T value) {
        Node node = new Node(value);
        if(isEmpty()){
            head = tail = node;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        else {
            T value = head.data;
            head = head.next;
            size--;
            return value;
        }
    }

    @Override
    public boolean contains(T value) {
        Node temp = head;
        while(temp!=null){
            if(temp.data == value)
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void display() {
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp =temp.next;
        }
    }

    public boolean isEmpty(){
        return this.size ==0;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
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
