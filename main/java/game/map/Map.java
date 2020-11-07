package game.map;

import game.items.Potions;

public class Map {

    public void printMap(char[][] map) {
int length =map.length;
        for (int i = 0; i <length ; i++) {
            System.out.print("\t");
            System.out.print(i +":");
        }
        System.out.println();


        for (int row = 0; row <length ; row++) {
            System.out.print(row+":"+"\t");
            for (int column = 0; column <map.length ; column++) {
                System.out.print(map[row][column] + "\t");
            }
            System.out.println();
        }

    }
    public void addTreasure(char currentPlayer, char[][] chars){

    }

}
