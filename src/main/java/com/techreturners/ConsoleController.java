package com.techreturners;

import com.techreturners.enums.CardinalCompassPoint;

import java.util.Scanner;

public class ConsoleController {
    Scanner scan = new Scanner(System.in);

    private int promptForInt(String prompt, int min, int max) {
        boolean isValid = false;
        int result = 0;
        while (!isValid) {
            System.out.println(prompt);
            if (scan.hasNextInt()) {
                result = scan.nextInt();
                if(result < min || result > max){
                    System.out.println("Invalid value, must be between: " + min + " and " + max);
                }else {
                    isValid = true;
                }
            }
            scan.nextLine();
        }
        return result;
    }

    private char promptForChar(String prompt, String validChars) {
        boolean isValid = false;
        String line;
        char result = 'x';
        while (!isValid) {
            System.out.println(prompt);
            line = scan.nextLine();
            if(line.length() > 1){
                System.out.println("too long!");
            }else if(line.length() < 1){
                System.out.println("too short!");
            } else  {
                char check = line.charAt(0);
                if(validChars.indexOf(check) == -1) {
                    System.out.println("Invalid! only allows : " + validChars);
                } else {
                    result = check;
                    isValid = true;
                }
            }
        }
        return result;
    }

    private void addRover(Plateau plateau){
        Rover rover;

        String name = "";
        while (name.length() < 1) {
            System.out.println("What is the name of the Rover?");
            name = scan.nextLine();
        }

        char direction = promptForChar(String.format("What direction is Rover[%s] facing (NSEW)?", name), "NSEW");
        CardinalCompassPoint compassPoint = CardinalCompassPoint.fromChar(direction);

        boolean isOccupied = true;
        int x = 0,y = 0;
        while(isOccupied){
            x = promptForInt(String.format("What is Rover[%s]'s x coordinate?", name), 0, plateau.getWidth() -1);
            y = promptForInt(String.format("What is Rover[%s]'s y coordinate?", name), 0, plateau.getHeight() -1);
            isOccupied = plateau.isOccupied(x,y);
            if (isOccupied){
                System.out.println("Position is already occupied");
            }
        }

        rover = new Rover(x, y, compassPoint, plateau, name);

        System.out.println("Please enter the commands (LRM)");
        String inputLine = scan.nextLine();
        StringBuilder commands = new StringBuilder();
        StringBuilder junk = new StringBuilder();
        for(int i = 0; i < inputLine.length(); i++){
            if(inputLine.charAt(i) =='L' || inputLine.charAt(i) =='R' ||inputLine.charAt(i) =='M'){
                commands.append(inputLine.charAt(i));
            }else{
                junk.append(inputLine.charAt(i));
            }

        }
        if(commands.length() > 0){

            System.out.println(String.format("Sending these commands to rover[%s] : %s", name, commands.toString()));
        }else{
            System.out.println(String.format("No valid commands to send to rover [%s]", name));
        }
        if(junk.length() >0) {
            System.out.println("Ignoring these invalid commands: " + junk.toString());
        }

        for(int i = 0; i < commands.length(); i++){
            if(commands.charAt(i) == 'L'){
                rover.turnLeft();
            } else if (commands.charAt(i) == 'R') {
                rover.turnRight();
            } else if (commands.charAt(i) == 'M'){
                rover.move();

            }
        }

        System.out.println(String.format("Rover [%s] is in position %s", name, rover.getPosition()));

    }

    private void getUserInput(){
        System.out.println("Hello!!");
        int row = promptForInt("What is the width of the plateau?", 0 , Integer.MAX_VALUE);
        int column = promptForInt("What is the height of the plateau?", 0, Integer.MAX_VALUE);
        Plateau plateau = new Plateau(row, column);
        addRover(plateau);
        addRover(plateau);
        scan.close();
    }
    public static void main(String[] args) {
        ConsoleController ui = new ConsoleController();
        ui.getUserInput();
    }
}
