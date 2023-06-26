package dmdev.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterRunner {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("dmdev_resources", "writer.poem");

        Files.write(path, List.of("Hello World!", "Java"));


//        try (BufferedWriter fileWriter = Files.newBufferedWriter(path)) {
//            fileWriter.append("Hello world!");
//            fileWriter.newLine();
//            fileWriter.append("Java");
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
    }
}
