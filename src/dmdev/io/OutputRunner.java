package dmdev.io;

import java.io.*;
import java.nio.file.Path;

public class OutputRunner {
    public static void main(String[] args) {
        File file = Path.of("dmdev_resources", "output.txt").toFile();
        try (BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {

            String value = "Hello world!";
            fileOutputStream.write(value.getBytes());
            fileOutputStream.write(System.lineSeparator().getBytes());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
