package dmdev.io.task;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Path path = Path.of("dmdev_resources", "text.txt");

        try (Scanner console = new Scanner(path)) {
            String prev = null;

            if (console.hasNext()) {
                prev = console.next();
            }

            while (console.hasNext()) {
                String current = console.next();
                if (isEqualLastSymbolAndFirstSymbol(prev, current)) {
                    System.out.println(prev + " " + current);
                }
                prev = current;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static boolean isEqualLastSymbolAndFirstSymbol(String prev, String current) {
        return prev.charAt(prev.length() - 1) == current.charAt(0);
    }
}
