package oop.task18;

public class Rogue extends GameCharacter{
    @Override
    public void attack() {
        System.out.println("Разбойник атакует");
    }

    @Override
    public void defend() {
        System.out.println("Разбойник защищается");
    }

    @Override
    public void useItem() {
        System.out.println("Разбойник использует кинджал");
    }
}
