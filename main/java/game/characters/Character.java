package game.characters;

import game.items.Potions;
import game.map.Map;

import java.util.List;
import java.util.Random;

public class Character {
    public int hp;
    public int mp;
    public int str;
    public int def;
    public boolean isMale;
    public char characterMark;
    public List<Potions> equipment;


    public Character(int hp, int mp, int str, int def, boolean isMale, char characterMark, List<Potions> equipment) {
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

    public List<Potions> getEquipment() {
        return equipment;
    }

    public Character setEquipment(List<Potions> equipment) {
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
    //stworzyc enum direction

    public void characterPerformMoveRight(char[][] chars, char currentPlayer) throws ArrayIndexOutOfBoundsException {
        try {
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars.length; j++) {

                    if (chars[i][j] == currentPlayer) {
                        chars[i][j + 1] = currentPlayer;
                        chars[i][j] = 'X';
                        break;
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

    public void characterShowStats(Character character) {
        System.out.println("Your HP: " + character.getHp());
        System.out.println("Your MP: " + character.getMp());
        System.out.println("Your STR: " + character.getStr());
        System.out.println("Your DEF: " + character.getDef());
    }

    public static int getRandomValue(int upperRange) {
        Random random = new Random();


        return random.nextInt(upperRange);
    }

    public void findAnyPotion(char[][] chars, char currentPlayer) {

        int range = chars.length;


        if (chars[getRandomValue(range)][getRandomValue(range)] == currentPlayer) {
            equipment.add(Potions.defPotion);
            System.out.println("Def Potion added to your equipment");

        } else if (chars[getRandomValue(range)][getRandomValue(range)] == currentPlayer) {
            equipment.add(Potions.hpPotion);
            System.out.println("Hp Potion added to your equipment");
        } else if (chars[getRandomValue(range)][getRandomValue(range)] == currentPlayer) {
            equipment.add(Potions.largeHpPotion);
            System.out.println("Large HpPotion added to your equipment");
        } else if (chars[getRandomValue(range)][getRandomValue(range)] == currentPlayer) {
            equipment.add(Potions.mpPotion);
            System.out.println("Mp Potion added to your equipment");
        } else if (chars[getRandomValue(range)][getRandomValue(range)] == currentPlayer) {
            equipment.add(Potions.largeMpPotion);
            System.out.println("Large MpPotion added to your equipment");
        } else if (chars[getRandomValue(range)][getRandomValue(range)] == currentPlayer) {
            equipment.add(Potions.strPotion);
            System.out.println("Str Potion added to your equipment");
        }


    }

    public void useItemsInEquipment(Character character, String command) {
        if (equipment.contains(Potions.defPotion) && command.equalsIgnoreCase("def")) {
            character.setDef(def + 10);
            equipment.remove(Potions.defPotion);
            System.out.println("def+10");
        } else if (equipment.contains(Potions.hpPotion) && command.equalsIgnoreCase("hp")) {
            character.setHp(hp + 20);
            equipment.remove(Potions.hpPotion);
            System.out.println("hp+20");
        } else if (equipment.contains(Potions.largeHpPotion) && command.equalsIgnoreCase("LargeHp")) {
            character.setHp(hp + 40);
            equipment.remove(Potions.largeHpPotion);
            System.out.println("hp+40");
        } else if (equipment.contains(Potions.mpPotion) && command.equalsIgnoreCase("mp")) {
            character.setMp(mp + 20);
            equipment.remove(Potions.mpPotion);
            System.out.println("mp+20");
        }else if (equipment.contains(Potions.largeMpPotion)&&command.equalsIgnoreCase("LargeMp")){
            character.setMp(mp+40);
            equipment.remove(Potions.largeMpPotion);
            System.out.println("mp+40");

        }else if (equipment.contains(Potions.strPotion)&&command.equalsIgnoreCase("str")){
            character.setStr(str+10);
            equipment.remove(Potions.strPotion);
            System.out.println("str+10");
        }
    }


}