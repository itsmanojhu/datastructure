package com.ds.problemSoving.generic;

/*
You are visiting a farm that has a single row of fruit trees arranged from left to right.The trees are represented by an integer array fruits of size N, where fruits[i]  is the type of fruit the ith tree produces.
        You want to collect as much fruit as possible.However,the owner has some strict rules that you must follow :

        You only have two baskets , and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
        Starting from any tree of your choice,you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of the baskets.
        Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
        Given the integer array fruits , return the maximum number of fruits you can pick.
Example 1:

Input:
N = 3
fruits [ ] = { 2, 1, 2 }
Output: 3
Explanation: We can pick from all three trees.


Example 2:

Input:
N = 6
fruits [ ] = { 0, 1, 2, 2, 2, 2 }
Output: 5
Explanation: It's optimal to pick from trees(0-indexed) [1,2,3,4,5].

*/

public class MaxFruitsInBasket {
    public static void main(String[] args) {
        int a[] = {1,4,2,2,2,5,5,5,5,2,2,2,1,2,2,2};
        System.out.println(totalFruit(a));
    }

    private static int totalFruit(int[] a) {
        int t1Count=1,t2Count=1, maxCount=1,t1=a[0],t2=-1;
        for(int i=0;i<a.length;i++){
            if(a[i] == t1){
                t1Count++;
                t2Count++;
            } else if(a[i] == t2){
                t2=t1;
                t1 = a[i];
                t2Count=1;
                t1Count++;
            } else if(a[i] != t1 && a[i] != t2){
                maxCount = Math.max(maxCount, t1Count);
                t1Count = t2Count+1;
                t2Count=1;
                t2=t1;
                t1 =a[i];
            }
        }
        return Math.max(t1Count,maxCount);
    }
}
