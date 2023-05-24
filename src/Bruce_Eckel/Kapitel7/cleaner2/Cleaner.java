package Bruce_Eckel.Kapitel7.cleaner2;

public class Cleaner {
    private String s = "Cleaner";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Bruce_Eckel.Kapitel7.cleaner.Cleaner cleaner = new Bruce_Eckel.Kapitel7.cleaner.Cleaner();
        cleaner.dilute();
        cleaner.apply();
        cleaner.scrub();
        System.out.println(cleaner);
    }
}