package oop.task26;

public class Wand extends Weapon {

    public Wand(String name) {
        super(name);
    }

    @Override
    public void showWeaponInfo() {
        super.showWeaponInfo();
    }

    public void activateSpell(String spell) {
        System.out.printf("Кастуется заклинание %s с помощью Wand", spell);
    }
}
