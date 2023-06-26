package pattern.decorator.tort;

public class Main {
    public static void main(String[] args) {
        Backing backing = new Cake();
        backing.about();
        backing = new Cream(backing);
        backing.about();
        backing = new Chocolate(backing);
        backing = new Chocolate(backing);
        backing.about();

    }
}
