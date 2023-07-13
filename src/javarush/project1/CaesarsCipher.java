package javarush.project1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CaesarsCipher {

    public void encrypt(String fileAbsolutePath, int key) throws IOException {
        //
        Path inputFilePath = Path.of(fileAbsolutePath);
        Path outputFilePath = inputFilePath.resolveSibling("Encrypt" + inputFilePath.getFileName());

        String inputText = Files.readString(inputFilePath);

        StringBuilder encryptText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char currentSymbol = inputText.charAt(i);
            char encryptedSymbol = (char) (currentSymbol + key);
            encryptText.append(encryptedSymbol);
         }
        Files.writeString(outputFilePath, encryptText.toString(), StandardCharsets.UTF_8, StandardOpenOption.CREATE);
    }

    public void decrypt(String fileAbsolutePath, int key) throws IOException {
        Path inputFilePath = Path.of(fileAbsolutePath);
        String fileName = inputFilePath.getFileName().toString();
        String decryptedFileName = "Decrypt" + fileName.substring(7);
        Path outputFilePath = inputFilePath.resolveSibling(decryptedFileName);

        String inputText = Files.readString(inputFilePath);

        StringBuilder decryptText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char currentSymbol = inputText.charAt(i);
            char encryptedSymbol = (char) (currentSymbol - key);
            decryptText.append(encryptedSymbol);
        }
        Files.writeString(outputFilePath, decryptText.toString(), StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        }
    }
