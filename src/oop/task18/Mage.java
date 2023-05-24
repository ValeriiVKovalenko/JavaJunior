package oop.task18;

public class Mage extends GameCharacter {
    @Override
    public void attack() {
        System.out.println("Маг атакует");
    }

    @Override
    public void defend() {
        System.out.println("Маг защищается");
    }

    @Override
    public void useItem() {
        System.out.println("Маг использует посох");
    }
}
