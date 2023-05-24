package oop.construktor;

public class Child extends Parent{
    private String c = Main.print("Child.c");
    private String d = Main.print("Child.d");

    public Child() {
        Main.print("Child.constructor");
    }
}
