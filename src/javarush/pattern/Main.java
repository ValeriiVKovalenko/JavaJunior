package javarush.pattern;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        var printer = Printer.getInstance();
        var fileOutputStream = new FileOutputStream("printer.txt");
        var objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(printer);
        objectOutputStream.close();

        var fileInputStream = new FileInputStream("printer.txt");
        var objectInputStream = new ObjectInputStream(fileInputStream);
        var deserializedPrinter =(Printer) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("Singleton 1 is: " + printer);
        System.out.println("Singleton 2 is: " + deserializedPrinter);


    }
}
