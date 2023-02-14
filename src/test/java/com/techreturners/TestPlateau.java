package com.techreturners;

import com.techreturners.enums.CardinalCompassPoint;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

    public class TestPlateau {
        @Test
        public void setupGridTest() {
            Plateau plateau = new Plateau(2,3);
            assertEquals(2, plateau.getWidth());
            assertEquals(3, plateau.getHeight());

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


}
