package Bruce_Eckel.Kapitel7.instrument.minitask1;

public class Frog extends Amphibian {

    @Override
    public void jump() {
        System.out.println("Frog is jumping");
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        frog.jump();
    }
}
