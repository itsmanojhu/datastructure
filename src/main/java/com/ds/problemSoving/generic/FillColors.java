package com.ds.problemSoving.generic;

public class FillColors {
    public static void main(String[] args) {
        int screen[][] = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        int screen2[][] = new int[1000][1000];

        int x=3,y=1, newC=5;

        fillColors(screen2, x, y, newC);

        for(int i=0;i< screen.length;i++){
            for(int j=0;j<screen[0].length;j++){
                System.out.print(screen[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void fillColors(int[][] screen, int x, int y, int newC) {
        int prevC = screen[x][y];
        if(prevC == newC)
            return;

        changeColor(screen,x,y,prevC,newC);

    }

    private static void changeColor(int[][] screen, int x, int y, int prevC, int newC) {
        int rows = screen.length-1;
        int cols = screen[0].length-1;

        if(x<0 || y<0 || x>rows || y>cols || screen[x][y] != prevC)
            return;

        if(screen[x][y] == prevC) {
            screen[x][y] = newC;
            changeColor(screen,x+1,y,prevC,newC);
            changeColor(screen,x-1,y,prevC,newC);
            changeColor(screen,x,y+1,prevC,newC);
            changeColor(screen,x,y-1,prevC,newC);
        }
    }
}
