package collections.set.test1;

import java.util.Objects;

public class B {
    private Long a;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B b = (B) o;
        return a == b.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
