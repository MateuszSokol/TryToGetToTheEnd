package game;

import game.characters.Character;
import game.map.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameMainApp {
    public static void main(String[] args) {

        System.out.println("Hello player, welcome to this cruel world, try to get to '*' symbol to win game," +
                "u can only step forward or to the left or right u can't go back or neither diagonal, have fun and good luck");
        Scanner scanner = new Scanner(System.in);
        char[][] chars = {
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
        };
        List<String> equipment = new ArrayList<>();

        int temp = chars.length;
        Map map = new Map();
        Character character = new Character(100, 100, 10, 10, true, '$', equipment);
        chars[0][0] = '*';
        char currentPlayer = character.getCharacterMark();


        character.setCharacterMark('$');
        chars[chars.length - 1][chars.length - 1] = currentPlayer;


        System.out.println("if you want to print map just type 'm'");
        System.out.println("If you want to go forward type '^'");
        System.out.println("If you want to go left type '<'");
        System.out.println("If you want to go right type '>'");
        System.out.println("If you want to see items in equipment type 'e'");
        System.out.println("If you want to exit game type 'quit'");

        boolean isStart = true;
        while (isStart) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("m")) {
                map.printMap(chars);
            } else if (command.equalsIgnoreCase("e")) {
                for (int j = 0; j < equipment.size(); j++) {
                    System.out.println(equipment.get(j));
                }
            } else if (equipment.isEmpty() && command.equalsIgnoreCase("e")) {
                System.out.println("equipment is empty");
            } else if (command.equalsIgnoreCase("quit")) {
                isStart = false;
            }
            boolean moveLeft = false;
            if (command.equalsIgnoreCase(">")) {
                for (int i = 0; i <chars.length ; i++) {
                    for (int j = 0; j <chars.length ; j++) {
                        if (chars[i][j]==currentPlayer){
                            chars[i][j+1]=currentPlayer;
                            chars[i][j]='X';
                        }else if (j>=4){
                            System.out.println("You can't go outside map");
                            return;
                        }
                    }
                }


            } else if (command.equalsIgnoreCase("^")) {
                for (int i = 0; i <chars.length ; i++) {
                    for (int j = 0; j <chars.length ; j++) {
                        if (chars[i][j]==currentPlayer){
                            chars[i-1][j]=currentPlayer;
                            chars[i][j]='X';
                        }else if(j==0){
                            System.out.println("you can't go outside map");
                        }
                    }
                }
            } else if (command.equalsIgnoreCase("<")) {
                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j < chars.length ; j++) {
                        if (chars[i][j] == currentPlayer) {
                            chars[i][j - 1] = currentPlayer;
                            chars[i][j]='X';
                        }else if (i==0){
                            System.out.println("you can't go outside map");
                        }
                    }

                }
            }else if (character.getCharacterMark() == chars[0][0]) {
                System.out.println("you have won");
                isStart = false;
                }

            }

//    correct move left but need to type location
//else if (command.equalsIgnoreCase(">")){
//            System.out.println("type your location");
//            int locationX = scanner.nextInt();
//            int locationY = scanner.nextInt();
//            if (chars[locationX][locationY]==currentPlayer&&chars[locationX][locationY]!=chars[locationX][4]){
//                chars[locationX][locationY]='X';
//                chars[locationX][locationY+1]=currentPlayer;
//                System.out.println("You have moved right");
//            }else {
//                System.out.println("Invalid location try again");
//            }


//                if (chars[4][4] == character.getCharacterMark() && command.equalsIgnoreCase("^")) {
//                    chars[3][4] = character.getCharacterMark();
//                    chars[4][4] = 'X';
//
//                } else if (chars[4][4] == character.getCharacterMark() && command.equalsIgnoreCase("<")) {
//                    chars[4][3] = character.getCharacterMark();
//                    chars[4][4] = 'X';
//
//                }else if (chars[3][3]==character.getCharacterMark()&&command.equalsIgnoreCase("^")){
//                    chars[2][3]=character.getCharacterMark();
//                    chars[3][3]='X';
//                }else if (chars[2][3]==character.getCharacterMark()&&command.equalsIgnoreCase("<")){
//                    chars[2][2]=character.getCharacterMark();
//                    chars[2][3]='X';
//                }else if (chars[2][2]==character.getCharacterMark()&&command.equalsIgnoreCase("^")){
//                    chars[1][2]=character.getCharacterMark();
//                    chars[2][2]='X';
//                }else if (chars[1][2]==character.getCharacterMark()&&command.equalsIgnoreCase("<")){
//                    chars[1][1]=character.getCharacterMark();
//                    chars[1][2]='X';
//                }else if (chars[1][1]==character.getCharacterMark()&&command.equalsIgnoreCase("^")){
//                    chars[0][1]=character.getCharacterMark();
//                    chars[1][1]='X';
//
//                }else if (chars[0][1]==character.getCharacterMark()&&command.equalsIgnoreCase("<")){
//                    chars[0][0]=character.getCharacterMark();
//                    chars[0][1]='X';
//                }
//                else if (character.getCharacterMark() == chars[3][4] && command.equalsIgnoreCase("<")) {
//                    chars[3][3] = character.getCharacterMark();
//                    chars[3][4] = 'X';
//                }
//                else if (character.getCharacterMark() == chars[4][3] && command.equalsIgnoreCase("^")) {
//                    chars[3][3] = character.getCharacterMark();
//                    chars[4][3] = 'X';
//                } else if (character.getCharacterMark() == chars[4][3] && command.equalsIgnoreCase("<")) {
//                    chars[4][2] = character.getCharacterMark();
//                    chars[4][3] = 'X';
//                } else if (character.getCharacterMark()==chars[4][2]&&command.equalsIgnoreCase("<")){
//                    chars[4][1]=character.getCharacterMark();
//                    chars[4][2]='X';
//                } else if (character.getCharacterMark() == chars[4][1] && command.equalsIgnoreCase("<")) {
//                    chars[4][0]=character.getCharacterMark();
//                    chars[4][1]='X';
//                }else if (character.getCharacterMark()==chars[4][0]&&command.equalsIgnoreCase("^")){
//                    chars[3][0]=character.getCharacterMark();
//                    chars[4][0]='X';
//                }else if (character.getCharacterMark()==chars[3][0]&&command.equalsIgnoreCase("^")){
//                    chars[2][0]=character.getCharacterMark();
//                    chars[3][0]='X';
//                }else if (character.getCharacterMark()==chars[2][0]&&command.equalsIgnoreCase("^")){
//                    chars[1][0]=character.getCharacterMark();
//                    chars[2][0]='X';
//                }else if (character.getCharacterMark()==chars[1][0]&&command.equalsIgnoreCase("^")){
//                    chars[0][0]=character.getCharacterMark();
//                    chars[1][0]='X';
//                }else if (character.getCharacterMark()==chars[3][3]&&command.equalsIgnoreCase(">")){
//                    chars[3][4]=character.getCharacterMark();
//                    chars[3][3] ='X';
//                }else if (character.getCharacterMark()==chars[3][4]&&command.equalsIgnoreCase("^")){
//                    chars[2][4]=character.getCharacterMark();
//                    chars[3][4]='X';
//                }else if (character.getCharacterMark()==chars[2][4]&&command.equalsIgnoreCase("<")){
//                    chars[2][3]=character.getCharacterMark();
//                    chars[2][4]='X';
//                }else if (character.getCharacterMark()==chars[2][3]&&command.equalsIgnoreCase("^")){
//                    chars[1][3]=character.getCharacterMark();
//                    chars[2][3]='X';
//                }else if (character.getCharacterMark()==chars[1][3]&&command.equalsIgnoreCase(">")){
//                    chars[1][4]=character.getCharacterMark();
//                    chars[1][3]='X';
//                }else if (character.getCharacterMark()==chars[1][4]&&command.equalsIgnoreCase("^")){
//                    chars[0][4]=character.getCharacterMark();
//                    chars[1][4]='X';
//                }else if (character.getCharacterMark()==chars[0][4]&&command.equalsIgnoreCase("<")){
//                    chars[0][3]=character.getCharacterMark();
//                    chars[0][4]='X';
//
//                }else if (character.getCharacterMark()==chars[0][3]&&command.equalsIgnoreCase("<")){
//                    chars[0][2]=character.getCharacterMark();
//                    chars[0][3]='X';
//                }else if (character.getCharacterMark()==chars[0][2]&&command.equalsIgnoreCase("<")){
//                    chars[0][1]=character.getCharacterMark();
//                    chars[0][2]='X';
//                }else if (character.getCharacterMark()==chars[3][3]&&command.equalsIgnoreCase("<")){
//                    chars[3][2]=character.getCharacterMark();
//                    chars[3][3]='X';
//                }else if (character.getCharacterMark()==chars[3][2]&&command.equalsIgnoreCase("<")){
//                    chars[3][1]=character.getCharacterMark();
//                    chars[3][2]='X';
//                }else if (character.getCharacterMark()==chars[3][1]&&command.equalsIgnoreCase("^")){
//                    chars[2][1]=character.getCharacterMark();
//                    chars[3][1]='X';
//
//                }else if (character.getCharacterMark()==chars[2][1]&&command.equalsIgnoreCase("^")){
//                    chars[1][1]=character.getCharacterMark();
//                    chars[2][1]='X';
//                }else if (character.getCharacterMark()==chars[2][3]&&command.equalsIgnoreCase("<")){
//                   chars[2][2]= character.getCharacterMark();
//                   chars[2][3]='X';
//                }else if (character.getCharacterMark()==chars[2][2]&&command.equalsIgnoreCase("<")){
//                    chars[2][1]=character.getCharacterMark();
//                    chars[2][2]='X';
//                }else if (character.getCharacterMark()==chars[3][1]&&command.equalsIgnoreCase("<")){
//                    chars[3][0]=character.getCharacterMark();
//                    chars[3][1]='X';
//                }else if (character.getCharacterMark()==chars[2][1]&&command.equalsIgnoreCase("<")){
//                    chars[2][0]=character.getCharacterMark();
//                    chars[2][1]='X';
//                }else if (character.getCharacterMark()==chars[2][4]&&command.equalsIgnoreCase("^")){
//                    chars[1][4]=character.getCharacterMark();
//                    chars[2][4]='X';
//                }else if (character.getCharacterMark()==chars[1][4]&&command.equalsIgnoreCase("<")){
//                    chars[1][3]=character.getCharacterMark();
//                    chars[1][4]='X';
//                }else if (character.getCharacterMark()==chars[1][3]&&command.equalsIgnoreCase("<")){
//                    chars[1][2]=character.getCharacterMark();
//                    chars[1][3]='X';
//                }else if (character.getCharacterMark()==chars[1][2]&&command.equalsIgnoreCase("<")){
//                    chars[1][1]=character.getCharacterMark();
//                    chars[1][2]='X';
//                }else if (character.getCharacterMark()==chars[1][1]&&command.equalsIgnoreCase("^")){
//                    chars[0][1]=character.getCharacterMark();
//                    chars[1][1]='X';
//                }


            String hpPotion = "hp+10";
            if (character.getCharacterMark() == chars[4][3]) {
                character.setHp(character.hp + 10);
                System.out.println("Your hp has been increased by 10, your current hp is: " + character.getHp());
                equipment.add(hpPotion);

            }


        }
    }












