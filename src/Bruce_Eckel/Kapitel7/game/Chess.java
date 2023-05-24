package Bruce_Eckel.Kapitel7.game;

public class Chess extends BoardGame {

    public Chess() {
        super(11);
        System.out.println("Constructor Chess.");
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
    }
}
