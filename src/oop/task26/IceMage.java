package oop.task26;

public class IceMage extends Wizard implements SpellCaster {
    public IceMage(String name) {
        super(name);
    }

    @Override
    public void firstSkill() {
        System.out.println("IceMag бъет по области с помощью frostbite");
    }

    @Override
    public void secondSkill() {
        System.out.println("IceMag замораживает в куб с помощью crystalNova");
    }

    @Override
    public void ultimate() {
        System.out.println("IceMag бъет по области ультой с помощью freezingField");
    }

    public void attackWithWeapon(Weapon weapon) {
        System.out.printf("IceMag атакует с помощью %sа", weapon.getName());
    }
}
