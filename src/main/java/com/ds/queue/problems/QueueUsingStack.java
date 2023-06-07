package com.ds.queue.problems;

import java.util.Stack;

public class QueueUsingStack<Integer> {

        Stack<Integer> s1 ;
        Stack<Integer> s2 ;
        int size;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        this.size = 0;
    }

        public void enqueue(Integer data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            size++;
        }

        public int dequeue(){
            return (int) s1.pop();
        }

        public int peek(){
            return (int) s1.peek();
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size()==0;
        }




    public static void main(String[] args) {

    }
}
