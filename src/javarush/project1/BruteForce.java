package javarush.project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static javarush.project1.CaesarsCipher.PATH_DIRECTORY;


public class BruteForce {
    public void breakingTheCipher(String fileName) throws IOException {

        Path inputEncryptionFilePath = Path.of(PATH_DIRECTORY, fileName);
        Path crackedFilePath = Path.of(PATH_DIRECTORY, "BruteForce" + fileName);
        Map<Character, Integer> symbolCountMap = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(inputEncryptionFilePath);
             BufferedWriter writer = Files.newBufferedWriter(crackedFilePath)) {
            StringBuilder inputText = new StringBuilder();
            char[] buffer = new char[1024];
            int charsRead;

            while ((charsRead = reader.read(buffer)) != -1) {
                inputText.append(buffer, 0, charsRead);
            }

            for (int i = 0; i < inputText.length(); i++) {
                char currentSymbol = inputText.charAt(i);

                if (symbolCountMap.containsKey(currentSymbol)) {
                    int count = symbolCountMap.get(currentSymbol);
                    symbolCountMap.put(currentSymbol, count + 1);
                } else {
                    symbolCountMap.put(currentSymbol, 1);
                }
            }

            int maxCounter = Integer.MIN_VALUE;
            char symbol = 0;

            for (Map.Entry<Character, Integer> entry : symbolCountMap.entrySet()) {

                if (entry.getValue() > maxCounter) {
                    maxCounter = entry.getValue();
                    symbol = entry.getKey();
                }
            }

            int key = symbol - ' ';

            for (int i = 0; i < inputText.length(); i++) {
                char currentSymbol = inputText.charAt(i);
                char crackedSymbol = (char) (currentSymbol - key);
                writer.write(crackedSymbol);

            }
        }
    }
}
