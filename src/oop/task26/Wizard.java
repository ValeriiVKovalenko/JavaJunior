package oop.task26;

public abstract class Wizard {

    private String name;
    private int health;
    private int mana;
    private int damage;

    public Wizard(String name) {
        this.name = name;
        health = 1000;
        mana = 500;
        damage = 50;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getDamage() {
        return damage;
    }
}
