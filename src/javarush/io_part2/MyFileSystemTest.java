package javarush.io_part2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static java.nio.charset.StandardCharsets.UTF_8;


public class MyFileSystemTest {
    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = FileSystem.getFileSystem();
        final String path = "C:\\Users\\Valerii\\IdeaProjects\\example.txt";

        fileSystem.create(path);
        System.out.println("Файл успешно создан.");

        try (InputStream input = fileSystem.newInputStream(path)) {

            System.out.print("Содержимое файла:\t");
            System.out.println(read(input));
        }

        try (final OutputStream output = fileSystem.newOutputStream(path)) {
            output.write("JavaRush".getBytes(UTF_8));
            System.out.println("Данные записаны в файл.");
        }
    }

    private static String read(InputStream inputStream) throws IOException {
        return new String(inputStream.readAllBytes(), UTF_8);
    }
}
