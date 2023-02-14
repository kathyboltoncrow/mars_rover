package com.techreturners;

import com.techreturners.enums.CardinalCompassPoint;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

    public class TestPlateau {
        @Test
        public void setupGridTest() {
            Plateau plateau = new Plateau(2,3);
            assertEquals(3, plateau.getWidth());
            assertEquals(4, plateau.getHeight());

        }

        @Test
        public void addRoverTest(){
            Plateau plateau = new Plateau(5,5);
            Rover rover = new Rover(1,2, CardinalCompassPoint.NORTH, plateau);
            assertEquals(plateau.getCell(1,2), 'N');
            System.out.println(rover.toString());
        }
        @Test
        public void moveRoverTest(){
            Plateau plateau = new Plateau(5,5);
            Rover rover = new Rover(1,2, CardinalCompassPoint.NORTH, plateau);
            System.out.println(rover.toString());
            //LMLMLMLMM
            rover.turnLeft();
            System.out.println(rover.toString());
            rover.move();
            System.out.println(rover.toString());
            rover.turnLeft();
            System.out.println(rover.toString());
            rover.move();
            System.out.println(rover.toString());
            rover.turnLeft();
            System.out.println(rover.toString());
            rover.move();
            System.out.println(rover.toString());
            rover.turnLeft();
            System.out.println(rover.toString());
            rover.move();
            System.out.println(rover.toString());
            rover.move();
            System.out.println(rover.toString());

            System.out.println(rover.toString());
            assertEquals(plateau.getCell(1,3), 'N');
        }

        @Test
        public void moveRoverTest2(){
            Plateau plateau = new Plateau(5,5);
            Rover roverA = new Rover(1,2, CardinalCompassPoint.NORTH, plateau);
            //LMLMLMLMM
            roverA.turnLeft().move().turnLeft().move().turnLeft().move().turnLeft().move().move();
            System.out.println(roverA.toString());

            Rover roverB = new Rover(3,3, CardinalCompassPoint.EAST, plateau);
            //MMRMMRMRRM
            roverB.move().move().turnRight().move().move().turnRight().move().turnRight().turnRight().move();
            System.out.println(roverB.toString());
            assertEquals(plateau.getCell(1,3), 'N');
        }

        @Test
        public void moveRoverOutOfBoundsTest(){
            Plateau plateau = new Plateau(5,5);
            Rover roverA = new Rover(1,1, CardinalCompassPoint.WEST, plateau);
            //MM
            roverA.move();
            assertEquals(plateau.getCell(0,1), 'W');
            roverA.move();
            assertEquals(plateau.getCell(0,1), 'W');
            System.out.println(roverA.toString());

        }

        @Test
        public void collisionTest(){
            Plateau plateau = new Plateau(5,5);
            Rover roverA = new Rover(1,1, CardinalCompassPoint.WEST, plateau);

            Rover roverB = new Rover(2,1, CardinalCompassPoint.WEST, plateau);
            roverB.move();
            assertEquals(plateau.getCell(2,1), 'W');

        }


}
