package javarush.project1;

import java.io.IOException;
import java.util.Scanner;

public class UI {
    private final CaesarsCipher caesarsCipher;
    private final BruteForce bruteForce;
    private final Scanner console;

    public UI() {
        caesarsCipher = new CaesarsCipher();
        bruteForce = new BruteForce();
        console = new Scanner(System.in);
    }

    public CaesarsCipher getCaesarsCipher() {
        return caesarsCipher;
    }

    public BruteForce getBruteForce() {
        return bruteForce;
    }

    public void start() throws IOException {
        System.out.print(" 1-> Encryption\n 2-> Decryption\n 3-> Brute Force\nSelect the mode:");
        int selectedMod = console.nextInt();
        console.nextLine();

        switch (selectedMod) {
            case 1:
                System.out.print("Enter file name: ");
                String fileName = console.nextLine();
                getCaesarsCipher().encryption(fileName);
                break;
            case 2:
                System.out.print("Enter file encryption: ");
                String fileEncryptionName = console.nextLine();
                getCaesarsCipher().decryption(fileEncryptionName);
                break;
            case 3:
                System.out.print("Enter file name: ");
                String fileNameToCracked = console.nextLine();
                getBruteForce().breakingTheCipher(fileNameToCracked);
                break;
            default:
                System.out.println("Entered the wrong mode");
        }
    }
}
