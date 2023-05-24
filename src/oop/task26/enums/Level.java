package oop.task26.enums;

public enum Level {
    LEVEL_1(1, 25),
    LEVEL_2( 2, 50),
    LEVEL_3(3, 75),
    LEVEL_4(4, 100),
    LEVEL_5(5, 125);

    private int damage;
    private int lvl;

    Level(int lvl, int damage) {
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
