package game.characters;

import game.items.Potions;
import game.map.Map;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;

public class Character {
    public int hp;
    public int mp;
    public int str;
    public int def;
    public boolean isMale;
    public char characterMark;
    public List<String> equipment;


    public Character(int hp, int mp, int str, int def, boolean isMale, char characterMark, List<String> equipment) {
        this.hp = hp;
        this.mp = mp;
        this.str = str;
        this.def = def;
        this.isMale = isMale;
        this.characterMark = characterMark;
        this.equipment = equipment;
    }

    public int getHp() {
        return hp;
    }

    public Character setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public int getMp() {
        return mp;
    }

    public Character setMp(int mp) {
        this.mp = mp;
        return this;
    }

    public int getStr() {
        return str;
    }

    public Character setStr(int str) {
        this.str = str;
        return this;
    }

    public int getDef() {
        return def;
    }

    public Character setDef(int def) {
        this.def = def;
        return this;
    }

    public boolean isMale() {
        return isMale;
    }

    public Character setMale(boolean male) {
        isMale = male;
        return this;
    }

    public char getCharacterMark() {
        return characterMark;
    }

    public Character setCharacterMark(char characterMark) {
        this.characterMark = characterMark;
        return this;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public Character setEquipment(List<String> equipment) {
        this.equipment = equipment;
        return this;
    }

    public void characterPerformMoveLeft(char[][] chars, char currentPlayer) throws ArrayIndexOutOfBoundsException {

        try {
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars.length; j++) {
                    if (chars[i][j] == currentPlayer) {
                        chars[i][j - 1] = currentPlayer;
                        chars[i][j] = 'X';
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("You can't go out map");
        }
    }

    public void characterPerformMoveRight(char[][] chars, char currentPlayer) throws ArrayIndexOutOfBoundsException {
        try {
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars.length; j++) {
                    if (chars[i][j] == currentPlayer) {
                        chars[i][j+1] = currentPlayer;
                        chars[i][j] = 'X';
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("You can't go out map");
        }
    }


    public void characterPerformMoveForward(char[][] chars, char currentPlayer) throws ArrayIndexOutOfBoundsException {
        try {
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars.length; j++) {
                    if (chars[i][j] == currentPlayer) {
                        chars[i - 1][j] = currentPlayer;
                        chars[i][j] = 'X';

                    } else if (chars[i][0] == currentPlayer) {

                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("You can't go out map");
        }
    }

    public void showMap(char[][] chars) {

        Map map = new Map();
        map.printMap(chars);

    }

    public void showEq() {

        for (int j = 0; j < equipment.size(); j++) {
            System.out.println(equipment.get(j));

        }
        if (equipment.isEmpty()) {
            System.out.println("equipment is empty");
        }
    }

    public void addToEquipmentHpPotion(Character character) {
        Potions potions = new Potions();
        character.equipment.add(potions.getHpPotion());
        System.out.println("You have got hpPotion");

    }

    public void addToEquipmentLargeHpPotion(Character character) {
        Potions potions = new Potions();
        character.equipment.add(potions.getLargeHpPotion());
        System.out.println("You have got largeHpPotion");
    }

    public void addToEquipmentMpPotion(Character character) {
        Potions potions = new Potions();
        character.equipment.add(potions.getMpPotion());
        System.out.println("You have got mpPotion");
    }

    public void addToEquipmentLargeMpPotion(Character character) {
        Potions potions = new Potions();
        character.equipment.add(potions.getLargeMpPotion());
        System.out.println("You have got largeMpPotion");
    }

    public void addToEquipmentStrPotion(Character character) {
        Potions potions = new Potions();
        character.equipment.add(potions.getStrPotion());
        System.out.println("You have got strPotion");
    }

    public void addToEquipmentDefPotion(Character character) {
        Potions potions = new Potions();
        character.equipment.add(potions.getDefPotion());
        System.out.println("You have got defPotion");
    }

    public void characterShowStats(Character character) {
        System.out.println("Your HP: " + character.getHp());
        System.out.println("Your MP: " + character.getMp());
        System.out.println("Your STR: " + character.getStr());
        System.out.println("Your DEF: " + character.getDef());
    }

    public void foundedHpPotion(Character character, char currentPlayer, char[][] chars) {
        Random random = new Random();
        int randomArrIndex = random.nextInt(chars.length);
        if (currentPlayer == chars[randomArrIndex][randomArrIndex]) {
            character.addToEquipmentHpPotion(character);
        }

    }

    public void foundedMpPotion(Character character, char currentPlayer, char[][] chars) {
        Random random = new Random();
        int randomArrIndex = random.nextInt(chars.length);
        if (currentPlayer == chars[randomArrIndex][randomArrIndex]) {
            character.addToEquipmentMpPotion(character);
        }

    }

    public void foundedStrPotion(Character character, char currentPlayer, char[][] chars) {
        Random random = new Random();
        int randomArrIndex = random.nextInt(chars.length);
        if (currentPlayer == chars[randomArrIndex][randomArrIndex]) {
            character.addToEquipmentStrPotion(character);
        }
    }

    public void foundedDefPotion(Character character, char currentPlayer, char[][] chars) {
        Random random = new Random();
        int randomArrIndex = random.nextInt(chars.length);
        if (currentPlayer == chars[randomArrIndex][randomArrIndex]) {
            character.addToEquipmentDefPotion(character);
        }
    }

    public void foundedLargeHpPotion(Character character, char currentPlayer, char[][] chars) {
        Random random = new Random();
        int randomArrIndex = random.nextInt(chars.length);
        if (currentPlayer == chars[randomArrIndex][randomArrIndex]) {
            character.addToEquipmentLargeHpPotion(character);
        }
    }

    public void foundedLargeMpPotion(Character character, char currentPlayer, char[][] chars) {
        Random random = new Random();
        int randomArrIndex = random.nextInt(chars.length);
        if (currentPlayer == chars[randomArrIndex][randomArrIndex]) {
            character.addToEquipmentLargeMpPotion(character);
        }
    }
}