package com.techreturners;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

    public class TestPlateau {
        @Test
        public void setupGridTest() {
            Plateau plateau = new Plateau(2,3);
            assertEquals(2, plateau.getWidth());
            assertEquals(3, plateau.getHeight());

        }


}
