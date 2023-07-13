package javarush.project1;



import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class BruteForce {
    public void bruteForceDecrypt(String fileAbsolutePath) throws IOException {
        Path inputFilePath = Path.of(fileAbsolutePath);
        Charset charset = StandardCharsets.UTF_8;
        String encryptedText = Files.readString(inputFilePath, charset);

        Path outputFilePath = inputFilePath.resolveSibling("DecryptedText.txt");

        for (int key = 1; key < 50; key++) {
            StringBuilder decryptedText = new StringBuilder();

            for (int i = 0; i < encryptedText.length(); i++) {
                char currentSymbol = encryptedText.charAt(i);
                char decryptedSymbol = (char) (currentSymbol - key);
                decryptedText.append(decryptedSymbol);
            }

            if (decryptedText.indexOf(", ") != -1 && decryptedText.indexOf("  ") == -1) {
                Files.writeString(outputFilePath, decryptedText.toString(), charset);
                break;
            }
        }
    }
}
