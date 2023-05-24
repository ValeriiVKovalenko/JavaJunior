package oop.task26;

public class FireMage extends Wizard implements SpellCaster {
    public FireMage(String name) {
        super(name);
    }

    @Override
    public void firstSkill() {
        System.out.println("FireMag бъет по области с помощью lightStrikeArray");
    }

    @Override
    public void secondSkill() {
        System.out.println("FireMag бъет по области с помощью dragonSlave");
    }

    @Override
    public void ultimate() {
        System.out.println("FireMag бъет точечно с помощью lagunaBlade");
    }

    public void attackWithWeapon(Weapon weapon) {
        System.out.printf("FireMag атакует с помощью %sа", weapon.getName());
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
