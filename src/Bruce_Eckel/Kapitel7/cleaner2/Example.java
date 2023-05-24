package Bruce_Eckel.Kapitel7.cleaner2;

public class Example extends Detergent {
    @Override
    public void scrub() {
        super.scrub();
    }

    public void sterilize() {
        cleaner.append(" sterilize()");
    }


    public static void main(String[] args) {
        Bruce_Eckel.Kapitel7.cleaner.Example example = new Bruce_Eckel.Kapitel7.cleaner.Example();
        example.scrub();
        example.sterilize();
    }
}