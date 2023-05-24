package Bruce_Eckel.Kapitel7.cleaner2;

public class Detergent {

    protected Cleaner cleaner = new Cleaner();

    public void scrub() {
        cleaner.append(" Detergent.scrub()");
        cleaner.scrub();
    }

    public void foam() {
        cleaner.append(" foam()");
    }

    public static void main(String[] args) {
        Bruce_Eckel.Kapitel7.cleaner.Detergent detergent = new Bruce_Eckel.Kapitel7.cleaner.Detergent();

        detergent.dilute();
        detergent.apply();
        detergent.scrub();
        detergent.foam();
        System.out.println(detergent);
        System.out.println("Проверяем базовый класс");
        Cleaner.main(args);
    }
}