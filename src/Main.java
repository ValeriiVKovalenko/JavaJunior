import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isEnd = false;
        while (!isEnd) {
            int x = scanner.nextInt();
            if (x == 100500) {
                isEnd = true;
                continue;
            }
            int y = scanner.nextInt();
            if (y == 100500) {
                isEnd = true;
            }

            System.out.println(x > y);

        }
    }


}