package oop.task26;

import java.util.Random;

public abstract class Weapon {

    private String name;
    private int level;
    private int rarity;
    private Random random = new Random();

    public Weapon(String name) {
        this.name = name;
        level = random.nextInt(5) + 1;
        rarity = random.nextInt(5) + 1;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getRarity() {
        return rarity;
    }

    public void showWeaponInfo() {
        System.out.printf("Оружие [%s; Уровень: %d; Качество: %d; ",
                getName(), getLevel(), getRarity());
    }
}
