package Bruce_Eckel.Kapitel7.orc;

public class Orc extends Villain {

    private int orcNumber;

    public Orc(String name, int octNumber) {
        super(name);
        this.orcNumber = octNumber;
    }

    public void change(String name, int octNumber) {
        set(name);
        this.orcNumber = octNumber;
    }

    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Лимбургер", 12);
        System.out.println(orc);
        orc.change("Боб", 19);
        System.out.println(orc);
    }
}
