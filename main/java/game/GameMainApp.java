package game;

import game.characters.Character;
import game.map.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMainApp {
    public static void main(String[] args) {
        System.out.println("Hello player, welcome to this cruel world, try to get to '*' symbol to win game," +
                "u can only step forward or to the left or right u can't go back or neither diagonal, have fun and good luck");
        Scanner scanner = new Scanner(System.in);
        boolean isFirstRound=true;
        boolean isSecondRound;
        char[][] chars = {
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
        };
        List<String> equipment = new ArrayList<>();

        Map map = new Map();
        Character character = new Character(100, 100, 10, 10, true, '$', equipment);
        chars[0][0] = '*';

        character.setCharacterMark('$');
        chars[4][4] = character.getCharacterMark();




            System.out.println("if you want to print map just type 'm'");
            System.out.println("If you want to go forward type '^'");
            System.out.println("If you want to go left type '<'");
            System.out.println("If you want to go right type '>'");
            System.out.println("If you want to see items in equipment type 'e'");
            String command = scanner.nextLine();

                if (command.equalsIgnoreCase("m")) {
                    map.printMap(chars);
                }

                 if (chars[4][4] == character.getCharacterMark() && command.equalsIgnoreCase("^")) {
                    chars[3][4] = character.getCharacterMark();
                    chars[4][4] = 'X';

                } else if (chars[4][4] == character.getCharacterMark() && command.equalsIgnoreCase("<")) {
                    chars[4][3] = character.getCharacterMark();
                    chars[4][4] = 'X';
                } else if (chars[4][4] == character.getCharacterMark() && command.equalsIgnoreCase("e")) {
                    for (int j = 0; j < equipment.size(); j++) {
                        System.out.println(equipment.get(j));
                    }
                } else if (equipment.isEmpty() && command.equalsIgnoreCase("e")) {
            System.out.println("equipment is empty");
        }




            String hpPotion = "hp+10";
            if (character.getCharacterMark() == chars[4][3]) {
                character.setHp(character.hp + 10);
                System.out.println("Your hp has been increased by 10, your current hp is: " + character.getHp());
                equipment.add(hpPotion);

            }





                if (character.getCharacterMark() == chars[3][4] && command.equalsIgnoreCase("^")) {
                    chars[2][4] = character.getCharacterMark();
                    chars[3][4] = 'X';
                } else if (character.getCharacterMark() == chars[4][3] && command.equalsIgnoreCase("<")) {
                    chars[4][2] = character.getCharacterMark();
                    chars[4][3] = 'X';
                } else if (character.getCharacterMark() == chars[3][4] && command.equalsIgnoreCase("<") || command.equalsIgnoreCase("^")) {
                    chars[3][3] = character.getCharacterMark();
                    chars[3][4] = 'X';

                }
                isSecondRound=false;
            }

        }




