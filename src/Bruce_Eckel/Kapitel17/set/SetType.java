package Bruce_Eckel.Kapitel17.set;

import java.util.Objects;

public class SetType {
    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SetType && (i == ((SetType) o).i);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
    //    @Override
//    public int hashCode() {
//        return Objects.hash(i);
//    }
}
