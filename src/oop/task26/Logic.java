package oop.task26;

import oop.task26.enums.Level;
import oop.task26.enums.Rarity;

import java.util.Random;

public class Logic {

    public Wizard createWizard(int number) {
        if(number == 1) {
            return new FireMage("FireMage");
        } else if(number == 2) {
            return new IceMage("IceMage");
        }
        else {
            System.out.println("Выбран персонаж неверно");
            return null;
        }
    }

    public Wizard createWizardAI() {
        Random random = new Random();
        int randomWizard = random.nextInt(2) +1;
        if(randomWizard == 1) {
            return new FireMage("FireMageAI");
        } else {
            return new IceMage("IceMageAI");
        }
    }

    public Weapon createWeapon(int number) {
     return getWeapon(number);
    }

    private Weapon getWeapon(int i) {
        switch (i) {
            case 1:
                return new Staff("Staff");
            case 2:
                return new Wand("Wand");
            case 3:
                return new Sword("Sword");
            default:
                return null;
        }
    }

    public Weapon createWeaponAi() {
        Random random = new Random();
        int temp = random.nextInt(3) + 1;
        return getWeapon(temp);
    }

    public int verifyWizardDmg(Wizard wizard, Weapon weapon) {
        return wizard.getDamage() + searchWeaponLvlDmg(weapon.getLevel()) +
                searchWeaponLvlRarity(weapon.getRarity());
    }

    private int searchWeaponLvlDmg(int currentLevel) {

        for (Level lvl : Level.values()) {
            if(lvl.getLvl() == currentLevel) {
                return lvl.getDamage();
            }
        }
        return 0;
    }

    private int searchWeaponLvlRarity(int currentLevel) {

        for (Rarity rar : Rarity.values()) {
            if(rar.getLvl() == currentLevel) {
                return rar.getDamage();
            }
        }
        return 0;
    }

    public void showWeaponInfo(Weapon weapon) {
        weapon.showWeaponInfo();
    }

//    public int getHealth() {
//        return wizard.getHealth();
//    }

//    public int getMana() {
//        return wizard.getMana();
//    }
}
