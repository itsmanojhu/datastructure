package com.ds.stack.implementation;

import com.ds.stack.StackSkeleton;
import lombok.Getter;
import lombok.Setter;

public class StackUsingLinkedList<T> implements StackSkeleton<T> {
    Node head;
    int size;

    @Getter
    @Setter
    public class Node{
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public StackUsingLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public void push(T data){
        Node node = new Node(data);
        if(size()>0){
            node.setNext(head);
        }
        head = node;
        size++;
    }

    public T pop(){
        if(size()>0) {
            T value = head.data;
            head = head.next;
            size--;
            return value;
        } else throw new IllegalArgumentException("Stack is empty");
    }

    @Override
    public T peek() {
        if(size()>0)
            return head.getData();
        else throw new IllegalArgumentException("Stack is empty");
    }

    @Override
    public boolean contains(T value) {
        Node temp = head;
        while(temp != null){
            if(temp.data.equals(value)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public T getData(T value) {
        while(head != null){
            T data = head.getData();
            head = head.next;
            size--;
            if(data.equals(value)){
                return data;
            }
        }
        throw new IllegalArgumentException("Not found. Stack is empty");
    }

    public void removeMiddleElement(){
        Node curr = head;
        Node prev = head;
        Node next = head.next;
        for(int i=0;i<=size()/2;i++){
            int index = (size()/2);
            if(i==index){
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = next;
            next = curr.next;
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
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
        System.out.println(stack.getData(4));//4
        System.out.println(stack.size());//0
    }
}
