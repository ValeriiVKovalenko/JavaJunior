package oop.task18;

public class Warrior extends GameCharacter {
    @Override
    public void attack() {
        System.out.println("Воин атакует.");
    }

    @Override
    public void defend() {
        System.out.println("Воин защищается.");
    }

    @Override
    public void useItem() {
        System.out.println("Воин использует меч.");
    }
}
