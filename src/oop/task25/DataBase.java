package oop.task25;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Reader> readers;

    public DataBase() {
        readers = new ArrayList<>(10);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }
}
