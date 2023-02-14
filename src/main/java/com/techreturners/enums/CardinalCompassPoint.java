package com.techreturners.enums;

public enum CardinalCompassPoint {
    NORTH {
        @Override
        public char toChar() {
            return 'N';
        }
    },
    EAST{
        @Override
        public char toChar() {
            return 'E';
        }
    },
    SOUTH{
        @Override
        public char toChar() {
            return 'S';
        }
    },
    WEST{
        @Override
        public char toChar() {
            return 'W';
        }
    };

    public char toChar(){
        return 'X';
    }

    public static CardinalCompassPoint fromChar(char ch) {
        CardinalCompassPoint ccp = null;

        switch (ch) {
            case 'N':
                ccp = NORTH;
                break;
            case 'S':
                ccp = SOUTH;
                break;
            case 'E':
                ccp = EAST;
                break;
            case 'W':
                ccp = WEST;
                break;
            default:
                ccp = null;
        }

        return ccp;
    }

}
