package oop.construktor;

public class Parent {
    private String a = Main.print("Parent.a");
    private String b = Main.print("Parent.b");

    public Parent() {
        Main.print("Parent.constructor");
    }
}
