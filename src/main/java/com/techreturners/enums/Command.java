package com.techreturners.enums;

public enum Command {
    LEFT {
        @Override
        public char toChar() {
            return 'L';
        }
    },
    RIGHT {
        @Override
        public char toChar() {
            return 'R';
        }
    },

    MOVE {
        @Override
        public char toChar() {
            return 'M';
        }
    };

    public char toChar() {
        return 'X';
    }
}
