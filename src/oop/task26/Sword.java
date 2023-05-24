package oop.task26;

public class Sword extends Weapon {

    private int weight;

    public Sword(String name) {
        super(name);
        this.weight = weight;
    }

    @Override
    public void showWeaponInfo() {
        super.showWeaponInfo();
    }

    public void slash(String target) {
        System.out.printf("Порезать %s с помощью Sword", target);
    }
}
