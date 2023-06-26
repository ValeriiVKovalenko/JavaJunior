package dmdev.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderRunner {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("dmdev_resources", "text.txt");

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }

    }
}
