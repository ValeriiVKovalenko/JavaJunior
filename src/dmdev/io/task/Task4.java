package dmdev.io.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task4 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "dmdev", "io", "task", "Task3.java");

        String stringValue = Files.readString(path);
        String result = stringValue.replace("public", "private");

        Path resultPath = Path.of("dmdev_resources", "Task3.java");
        Files.writeString(resultPath, result);
    }
}
