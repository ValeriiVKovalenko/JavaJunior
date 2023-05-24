package Bruce_Eckel.Kapitel7.homer;

public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0F);
        b.doh(new Milhouse());
    }
}
