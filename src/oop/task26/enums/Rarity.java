package oop.task26.enums;

public enum Rarity {
    RARITY_1(1,30),
    RARITY_2(2,60),
    RARITY_3(3,90),
    RARITY_4(4,120),
    RARITY_5(5,150);

    private int lvl;
    private int damage;

    Rarity(int lvl, int damage) {
        this.lvl = lvl;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getLvl() {
        return lvl;
    }
}
