package Bruce_Eckel.Kapitel17.set;


public class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }

    public int compareTo(TreeType arg) {
        return this.i - arg.i;
    }
}
