package com.ds.hashmap.implementation;

import com.ds.hashmap.HashTableSkeleton;
import lombok.Getter;
import lombok.Setter;

public class HashTableImpl<X, Y> implements HashTableSkeleton<X,Y> {
    HashEntry<X,Y> data[];
    int capacity;
    int size;

    @Getter
    @Setter
    private class HashEntry<X, Y>{
        X key;
        Y value;

        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTableImpl(int capacity) {
        this.capacity = capacity;
        this.data = new HashEntry[this.capacity];
        this.size = 0;
    }

    @Override
    public void put(X key, Y value) {
        int hash = calculateHashValue(key);
        data[hash] = new HashEntry<>(key, value);
        size++;
    }

    @Override
    public Y get(X key) {
        int hash = calculateHashValue(key);
        if(data[hash] == null)
            return null;
        else return data[hash].getValue();
    }

    @Override
    public Y delete(X key) {
        int hash = calculateHashValue(key);

        if(data[hash] == null)
           throw new IllegalArgumentException("No elements");

        Y value = data[hash].getValue();

        data[hash] = null;
        size--;
        hash = (hash+1)%this.capacity;

        while(data[hash]!=null){
            HashEntry temp = data[hash];
            data[hash] = null;
            size--;
            put((X)temp.key, (Y)temp.value);
            hash = (hash+1)%this.capacity;
        }
        return value;
    }

    @Override
    public boolean containsKey(X key) {
        int hash = calculateHashValue(key);
        if(data[hash] == null)
            return false;
        return data[hash].getKey().equals(key);
    }

    @Override
    public boolean containsValue(Y value) {
        for(int i=0;i<size();i++){
            if(data[i] == null && data[i].getValue().equals(value))
                return true;
        }
        return false;
    }

    public int calculateHashValue(X key){
        int hash = key.hashCode() % this.capacity;
        while(data[hash] != null && !data[hash].getKey().equals(key)){
            hash = (hash+1)%this.capacity;
        }
        return hash;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isFull(){
        return size==capacity;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
