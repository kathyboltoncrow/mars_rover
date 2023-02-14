package com.techreturners;

public class Plateau {

    private char [][] grid;

    public Plateau(int row, int column) {
        grid = new char[row ][column ];
    }

    public int getWidth(){

        return grid.length;
    }

    public int getHeight(){

        return grid[0].length;
    }

    public char getCell(int x, int y){
        return grid[x][y];
    }


}

