package com.ds.hashmap;

public interface HashTableSkeleton<X, Y>{
    void put(X key, Y value);
    Y get(X key);
    Y delete(X key);
    boolean containsKey(X key);
    boolean containsValue(Y value);
    int size();
}
