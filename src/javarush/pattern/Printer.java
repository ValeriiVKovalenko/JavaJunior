package javarush.pattern;

import java.io.Serializable;

public class Printer implements Serializable {

    private static final Printer PRINTER = new Printer();

    private Printer() {}

    public static Printer getInstance() {
        return PRINTER;
    }
    public Object readResolve() {
        return PRINTER;
    }
}
