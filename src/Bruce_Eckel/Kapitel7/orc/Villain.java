package Bruce_Eckel.Kapitel7.orc;

public class Villain {

    private String name;

    protected void set(String nm) {
        name = nm;
    }

    public Villain(String name) {
        this.name = name;
    }

    public String toString() {
        return "Я объект Villain и мое имя " + name;
    }
}
