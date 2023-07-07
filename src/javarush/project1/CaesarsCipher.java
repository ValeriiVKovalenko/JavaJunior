package javarush.project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CaesarsCipher {
    public static final String PATH_DIRECTORY = "project1";

    public void encryption(String fileName) throws IOException {
        Path inputFilePath = Path.of(PATH_DIRECTORY, fileName);
        Path outputFilePath = Path.of(PATH_DIRECTORY, "Encryption" + fileName);

        try (BufferedReader reader = Files.newBufferedReader(inputFilePath);
             BufferedWriter writer = Files.newBufferedWriter(outputFilePath)) {


            char[] buffer = new char[1024];
            int charsRead;

            while ((charsRead = reader.read(buffer)) != -1) {
                for (int i = 0; i < charsRead; i++) {
                    char currentSymbol = buffer[i];
                    int offset = 3;

                    char newSymbol = (char) (currentSymbol + offset);
                    writer.write(newSymbol);
                }
            }
        }
    }

    public void decryption(String fileName) throws IOException {
        Path inputFilePath = Path.of(PATH_DIRECTORY, fileName);
        Path outputFilePath = Path.of(PATH_DIRECTORY, "De" + fileName.substring(2));

        try (BufferedReader reader = Files.newBufferedReader(inputFilePath);
             BufferedWriter writer = Files.newBufferedWriter(outputFilePath)) {

            char[] buffer = new char[1024];
            int charsRead;

            while ((charsRead = reader.read(buffer)) != -1) {
                for (int i = 0; i < charsRead; i++) {
                    char c = buffer[i];
                    int offset = 3;
                    char newSymbol = (char) (c - offset);
                    writer.write(newSymbol);
                }
            }
        }
    }
}
