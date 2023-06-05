package collections.set.test1;

import java.util.Objects;

public class A {
    private int a;
    private int b;

    public A() {
    }

    @Override
    public int hashCode() {
        return a + b;
    }

    public int getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a1 = (A) o;
        return a == a1.a && b == a1.b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
