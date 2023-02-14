package com.techreturners;

import com.techreturners.enums.CardinalCompassPoint;

public class Rover {

    private int x;
    private int y;
    private CardinalCompassPoint direction;
    private Plateau plateau;

    public Rover(int x, int y, CardinalCompassPoint direction, Plateau plateau) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.plateau = plateau;
        if(plateau.isOccupied(x, y)) {
            throw new IllegalArgumentException("Position already occupied: " + x + " " + y);
        }
        this.plateau.setPosition(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CardinalCompassPoint getDirection() {
        return direction;
    }

    public Rover turnLeft(){
        if(direction.equals(CardinalCompassPoint.NORTH)){
            direction = CardinalCompassPoint.WEST;
        } else if (direction.equals(CardinalCompassPoint.EAST)){
            direction = CardinalCompassPoint.NORTH;
        } else if (direction.equals(CardinalCompassPoint.SOUTH)){
            direction = CardinalCompassPoint.EAST;
        } else {
            direction = CardinalCompassPoint.SOUTH;
        }
        this.plateau.setPosition(this);
        return this;

    }

    public Rover turnRight(){
        if(direction.equals(CardinalCompassPoint.NORTH)){
            direction = CardinalCompassPoint.EAST;
        } else if (direction.equals(CardinalCompassPoint.EAST)){
            direction = CardinalCompassPoint.SOUTH;
        } else if (direction.equals(CardinalCompassPoint.SOUTH)){
            direction = CardinalCompassPoint.WEST;
        } else {
            direction = CardinalCompassPoint.NORTH;
        }
        this.plateau.setPosition(this);
        return this;
    }

    public Rover move(){
        boolean canMove = true;
        int newX = x;
        int newY = y;

        if(direction.equals(CardinalCompassPoint.NORTH) && y == plateau.getHeight()-1){
            canMove = false;
        } else if (direction.equals(CardinalCompassPoint.SOUTH) && y == 0) {
            canMove = false;
        } else if (direction.equals(CardinalCompassPoint.EAST) && x == plateau.getWidth()-1) {
            canMove = false;
        } else if (direction.equals(CardinalCompassPoint.WEST) && x == 0) {
            canMove = false;
        } else {

            if(direction.equals(CardinalCompassPoint.NORTH)){
                newY++;
            } else if (direction.equals(CardinalCompassPoint.SOUTH)){
                newY--;
            } else if (direction.equals(CardinalCompassPoint.EAST)){
                newX++;
            } else {
                newX--;
            }

            if(plateau.isOccupied(newX, newY)){
                canMove = false;
            }
        }

        if(canMove){

            plateau.clearPosition(x,y);
            x = newX;
            y = newY;
            this.plateau.setPosition(this);
        }
        return this;
    }

    @Override
    public String toString() {

        return x + " " + y + " " + direction.toChar();

    }
}
