package dmdev.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileRunner {
    public static void main(String[] args) throws IOException {
        File file = new File("dmdev_resources/text.txt");

        System.out.println(file.createNewFile());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());


        File dir = new File("dmdev_resources/test/dir");
        System.out.println(dir.mkdirs());
    }
    
}
