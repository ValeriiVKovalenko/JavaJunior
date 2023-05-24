package Bruce_Eckel.Kapitel7.art.mini_task;

public class C extends A {
    public B b;

    public C() {
        super("some text");
        System.out.println("Constructor C");
    }

    public static void main(String[] args) {
        C c = new C();
    }
}
