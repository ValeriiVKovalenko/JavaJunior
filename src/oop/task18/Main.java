package oop.task18;

public class Main {
    public static void main(String[] args) {
        GameCharacter gameCharacter1 = new Warrior();
        gameCharacter1.attack();
        gameCharacter1.useItem();
        gameCharacter1.defend();

        System.out.println();

        GameCharacter gameCharacter2 = new Mage();
        gameCharacter2.attack();
        gameCharacter2.useItem();
        gameCharacter2.defend();

        System.out.println();

        GameCharacter gameCharacter3 = new Rogue();
        gameCharacter3.attack();
        gameCharacter3.useItem();
        gameCharacter3.defend();
    }
}
