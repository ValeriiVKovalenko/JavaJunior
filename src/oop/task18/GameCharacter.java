package oop.task18;
/*
Создайте класс GameCharacter, представляющий персонаж в компьютерной игре, с методами attack(), defend(), useItem().
Реализуйте классы Warrior, Mage и Rogue, которые наследуются от GameCharacter и переопределяют его методы. Создайте
экземпляры классов и вызовите их методы.
 */
public abstract class GameCharacter {

    public abstract void attack();

    public abstract void defend();

    public abstract void useItem();
}
