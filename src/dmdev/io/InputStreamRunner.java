package dmdev.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputStreamRunner {

    public static void main(String[] args) throws IOException {

//        File file = new File(String.join(File.separator, "dmdev_resources", "text.txt"));

        File file = Path.of("dmdev_resources", "text.txt").toFile();

        try (FileInputStream input = new FileInputStream(file)) {
            byte[] bytes = new byte[input.available()];
            int counter = 0;
            byte currentByte;

            while ((currentByte = (byte) input.read()) != -1) {
                bytes[counter++] = currentByte;
            }
            String value = new String(bytes);
            System.out.println(value);


//            String stringValue = new String(bytes);
//            System.out.println(stringValue);
        }
    }
}
