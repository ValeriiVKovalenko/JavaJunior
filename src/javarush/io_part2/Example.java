package javarush.io_part2;

import collections.set.test1.B;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Example {

    private static final String AVAILABLE_BYTES = "байтов, доступных для чтения ";
    private static final String WAS_READ = "прочитали: ";
    public static void main(String[] args) {
        byte[] arr = {1, 2, 3, 4, 5};

//        try (ByteArrayInputStream input = new ByteArrayInputStream(arr)) {
//            for (int i = 0; i < arr.length; i++) {
//                int data = input.read();
//                System.out.print(data + ", ");
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

//        try (ByteArrayInputStream input = new ByteArrayInputStream(arr)) {
//            System.out.println(AVAILABLE_BYTES + input.available());
//
//            input.read();
//            System.out.println(AVAILABLE_BYTES + input.available());
//
//            input.read();
//            System.out.println(AVAILABLE_BYTES + input.available());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

//        try (ByteArrayInputStream input = new ByteArrayInputStream(arr)) {
//            input.skip(2);
//
//            while (input.available() != 0) {
//                int data = input.read();
//                System.out.print(data + ", ");
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        try (ByteArrayInputStream input = new ByteArrayInputStream(arr)) {
            boolean isMarkSupported = input.markSupported();

            System.out.println("isMarkSupported: " + isMarkSupported);
            System.out.println(WAS_READ + input.read());
            System.out.println(WAS_READ + input.read());

            input.mark(1);
            System.out.println(WAS_READ + input.read());
            isMarkSupported = input.markSupported();
            System.out.println("isMarkSupported: " + isMarkSupported);

            System.out.println("вызов метода reset()");
            input.reset();

            isMarkSupported = input.markSupported();
            System.out.println("isMarkSupported: " + isMarkSupported);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
