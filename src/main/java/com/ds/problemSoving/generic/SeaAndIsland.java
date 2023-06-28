package com.ds.problemSoving.generic;

import java.util.function.Function;

public class SeaAndIsland {
    public static void main(String[] args) {
        int M[][] = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        System.out.println(countIslands(M));
    }

    private static int countIslands(int[][] m) {
        int rows = m.length, cols=m[0].length;
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(m[i][j] == 1) {
                    count++;
                    isIsland(m, i, j, rows, cols);
                }
            }
        }
        return count;
    }

    private static void isIsland(int[][] m, int i, int j, int rows, int cols) {
        if(i<0 || j<0 ||  i>rows-1 || j>cols-1 || m[i][j]!=1)
            return;

        if(m[i][j] == 1){
            m[i][j] = 0;
            isIsland(m, i, j+1, rows, cols);
            isIsland(m, i, j-1, rows, cols);
            isIsland(m, i+1, j, rows, cols);
            isIsland(m, i-1, j, rows, cols);
            isIsland(m, i+1, j+1, rows, cols);
            isIsland(m, i+1, j-1, rows, cols);
            isIsland(m, i-1, j+1, rows, cols);
            isIsland(m, i-1, j-1, rows, cols);
        }
    }
}
