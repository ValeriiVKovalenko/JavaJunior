package Bruce_Eckel.Kapitel7.game.task2;

public class Stem extends Root {
    public Stem(Component1 component1, Component2 component2, Component3 component3) {
        super(component1,component2, component3);
        System.out.println("Constructor Stem");
    }

    public static void main(String[] args) {
        Component1 c1 = new Component1(1);
        Component2 c2 = new Component2(2);
        Component3 c3 = new Component3(3);
        Stem stem = new Stem(c1, c2 , c3);
    }
}
