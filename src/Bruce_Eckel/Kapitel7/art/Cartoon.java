package Bruce_Eckel.Kapitel7.art;

public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Конструктор класса Cartoon.");
    }

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}
