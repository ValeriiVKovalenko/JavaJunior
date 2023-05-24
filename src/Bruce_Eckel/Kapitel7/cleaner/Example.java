package Bruce_Eckel.Kapitel7.cleaner;

public class Example extends Detergent {

    @Override
    public void scrub() {
       super.scrub();
    }

    public void sterilize() {
        append(" sterilize()");
    }


    public static void main(String[] args) {
        Example example = new Example();
        example.scrub();
        example.sterilize();

    }
}
