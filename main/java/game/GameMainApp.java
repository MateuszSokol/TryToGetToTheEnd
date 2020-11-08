package game;

import game.characters.Character;
import game.items.Potions;
import game.map.Map;

import java.util.ArrayList;
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
        List<Potions> equipment = new ArrayList<>();


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
        System.out.println("If you want to see stats type 's'");

        boolean isStart = true;

        while (isStart) {
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("<")) {
                character.characterPerformMoveLeft(chars, currentPlayer);
            } else if (command.equalsIgnoreCase(">")) {
                character.characterPerformMoveRight(chars, currentPlayer);
            } else if (command.equalsIgnoreCase("^")) {
                character.characterPerformMoveForward(chars, currentPlayer);
            } else if (command.equalsIgnoreCase("m")) {
                character.showMap(chars);
            } else if (command.equalsIgnoreCase("e")) {
                character.showEq();
                System.out.println("If u want to use any items in eq u must type its name like 'hp'");

            } else if (command.equalsIgnoreCase("quit")) {

                isStart = false;
            }
            else if (command.equalsIgnoreCase("s")){
                character.characterShowStats(character);
            }


            character.findAnyPotion(chars,currentPlayer);
            character.useItemsInEquipment(character,command);




if (chars[0][0]==currentPlayer){
    isStart=false;
    System.out.println("You have won congratulation");
}
        }


    }


}













