package com.techreturners;

public class Plateau {
    private static final char EMPTY_CELL = '\u0000';

    private char [][] grid;

    public Plateau(int row, int column) {
        grid = new char[row + 1][column + 1];
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

    public void setPosition(Rover rover){
        int x = rover.getX();
        int y = rover.getY();
        char direction = rover.getDirection().toChar();

        grid[x][y] = direction;

    }

    public void clearPosition(int x, int y){
        grid[x][y] = EMPTY_CELL;
    }

    public boolean isOccupied(int x, int y){
        boolean isOccupied = false;
        if ((x >= 0 && x < getWidth()) && (y >= 0 && x < getHeight())) {
            char cell = grid[x][y];
            if (cell != EMPTY_CELL) {
                isOccupied = true;
            }
        }
        return isOccupied;
    }



}

