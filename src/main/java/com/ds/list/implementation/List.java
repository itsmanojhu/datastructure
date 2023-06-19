package com.ds.list.implementation;

import com.ds.list.ListSkeleton;

public class List implements ListSkeleton {
    Node head;
    Node tail;
    int size;

    public void reverseList() {
        Node current = head;
        Node prev=null,next=null;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    private static class Node{
        java.lang.Integer data;
        Node next;

        public Node(Integer data) {
            this.data = data;
            this.next = null;
        }
    }

    public List() {
        this.head = null;
        this.tail = null;
        this.size=0;
    }

    @Override
    public void addFirst(Integer data) {
        Node node = new Node(data);
        if(isEmpty()){
           head = tail =node;
        } else {
            node.next = head;
            head = node;
        }

        size++;
    }

    @Override
    public void addLast(Integer data) {
        Node node = new Node(data);
        if(isEmpty()){
           head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void addAt(int position, Integer data) {
        if(position > size() || position < 0)
            throw new ArrayIndexOutOfBoundsException();
        if(size() == 0) {
            addFirst(data);
            return;
        }
        Node node = new Node(data);
        Node curr = head;
        Node prev = null;


        for(int i=0;i<=position;i++){
            if(i==position){
                if(prev==null){
                    node.next = head;
                    head =node;
                } else {
                    prev.next = node;
                    node.next = curr;
                }
                size++;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    @Override
    public Integer remove() {
        if(isEmpty())
            return -1;
        else {
            Node prev=null;
            Node curr = head;
            while(curr.next!=null){
                prev = curr;
                curr = curr.next;
            }
            if(prev == null){
                int i = head.data;
                head = null;
                size--;
                return i;
            } else {
                int i = tail.data;
                tail = prev;
                tail.next = null;
                size--;
                return i;
            }
        }
    }

    @Override
    public Integer removeAt(int index) {
        if(index>size()-1)
            return -1;
        else {
            Node curr = head;
            Node prev=null;
            for(int i=0;i<index;i++){
                prev = curr;
                curr = curr.next;
            }
            int v;
            if(prev == null){
                v = head.data;
                head = head.next;
            } else {
                v = curr.data;
                prev.next = curr.next;
            }
            size--;
            return v;
        }
    }

    @Override
    public Integer get(int index) {
        if (index >= size() || index < 0)
            return -1;
        Node temp = head;
        for (int i = 0; i < size(); i++) {
            if (i == index) {
                return temp.data;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public boolean contains(Integer data) {
       Node temp = head;
       while(temp!=null){
           if(temp.data.equals(data))
               return true;
       }
       return false;
    }

    @Override
    public void display() {
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    public static void main(String[] args) {
        List list = new List();

        list.addAt(0,5);//5
        list.addFirst(3);//35
        list.addLast(1);//351
        list.addFirst(4);//4351
        list.addLast(2);//43512
        list.addLast(1);//435121
        list.addLast(2);//4351212
        list.display();
       //list.head.next.next.next.next = list.head;
        System.out.println("====================");
        System.out.println(detectLoop(list));
        System.out.println(printMiddleElement(list));
        deleteMiddleElement(list);
        System.out.println("====================");
        list.display();


    }

    private static void deleteMiddleElement(List list) {
        Node fast = list.head;
        Node slow = list.head;
        Node prev = null;
        while(fast!=null && slow!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev!=null)
            prev.next = slow.next;
    }

    private static int printMiddleElement(List list) {
        Node fast = list.head;
        Node slow = list.head;
        while (fast!=null && slow!= null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    private static boolean detectLoop(List list) {
        Node fast = list.head;
        Node slow = list.head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
