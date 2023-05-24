package oop.task26;

import java.util.Scanner;

public class Start {

private Logic logic = new Logic();

    public void startGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в \"Битву Магов\"\n" +
                "Выберите мага:\n" +
                "1 - FireMage; 2 - IceMage");

        int wizardChoose = scanner.nextInt();
        Wizard gameCharacter = logic.createWizard(wizardChoose);
        System.out.printf("Отлично. Ваш персонаж %s создан.%n", gameCharacter.getName());

        System.out.println("Теперь выберете оружие:\n" +
                "1 - Staff; 2 - Wand; 3 - Sword");
        int weaponChoose = scanner.nextInt();

        Weapon weaponCharacter = logic.createWeapon(weaponChoose);
        int damageCharacter = logic.verifyWizardDmg(gameCharacter, weaponCharacter);

        System.out.printf("Отлично. Вы выбрали %s.%n", weaponCharacter.getName());
        logic.showWeaponInfo(weaponCharacter);
        System.out.printf("Ваш урон: %d]%n", damageCharacter);


        Wizard wizardAI = logic.createWizardAI();
        Weapon weaponAI = logic.createWeaponAi();
        int damageAI = logic.verifyWizardDmg(wizardAI, weaponAI);

        System.out.printf("Ваш противник: %s.%n", wizardAI.getName());
        logic.showWeaponInfo(weaponAI);
        System.out.printf("Урон AI: %d]%n", damageAI);








    }

}
