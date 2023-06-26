package dmdev.io.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task1 {
    private static final String VOWELS = "уеыаоэяию";
    public static void main(String[] args) {
        Path path = Path.of("dmdev_resources", "text.txt");

        try (Scanner console = new Scanner(path)) {
            while (console.hasNext()) {
                String word = console.next();
                char firstSymbol = word.charAt(0);
                if (VOWELS.indexOf(firstSymbol) != -1) {
                    System.out.println(word);
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
