package com.ds.list;

public interface ListSkeleton {
    void addFirst(Integer data);
    void addLast(Integer data);
    void addAt(int position, Integer data);
    Integer remove();
    Integer removeAt(int index);
    Integer get(int index);
    void display();
    boolean contains(Integer data);
    int size();
    boolean isEmpty();
}
