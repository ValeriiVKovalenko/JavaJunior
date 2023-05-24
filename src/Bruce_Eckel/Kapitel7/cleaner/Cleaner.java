package Bruce_Eckel.Kapitel7.cleaner;

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
        Cleaner cleaner = new Cleaner();
        cleaner.dilute();
        cleaner.apply();
        cleaner.scrub();
        System.out.println(cleaner);
    }
}
