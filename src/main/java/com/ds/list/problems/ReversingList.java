package com.ds.list.problems;

import com.ds.list.implementation.List;

public class ReversingList {

    public static void main(String[] args) {
        List list = new List();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
        System.out.println("=========================");
        list.reverseList();
        list.display();
    }

    private static void reverlist(List list) {

    }
}
