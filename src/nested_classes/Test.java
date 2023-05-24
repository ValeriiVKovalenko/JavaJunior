package nested_classes;

public class Test {
    static String name;
    void method() {
        System.out.println();
    }
    static class A {
        static int a = 5;
        static String lastname = "Frank";
    }

    public static void main(String[] args) {
        Test test = new Test();
        Test.A staticA = new A();
    }
}

