package game.characters;

import java.util.List;

public class Character {
    public int hp;
    public int mp;
    public int str;
    public int def;
    public boolean isMale;
    public char characterMark;
    public List<String> equipment;



    public Character(int hp, int mp, int str, int def, boolean isMale,char characterMark,List<String>equipment) {
        this.hp = hp;
        this.mp = mp;
        this.str = str;
        this.def = def;
        this.isMale = isMale;
        this.characterMark=characterMark;
        this.equipment =equipment;
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
        this.characterMark =characterMark;
        return this;
    }
}
