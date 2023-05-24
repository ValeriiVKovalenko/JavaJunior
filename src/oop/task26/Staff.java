package oop.task26;

public class Staff extends Weapon {

    public Staff(String name) {
        super(name);
    }

    @Override
    public void showWeaponInfo() {
        super.showWeaponInfo();
    }

    public void castSpell(String spell) {
        System.out.printf("Кастуется заклинание %s c помощью Staff", spell);
    }

}
