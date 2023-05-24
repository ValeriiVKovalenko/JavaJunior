package javarush.site;

import java.util.Scanner;

public class Site {

    private Loginisation loginisation = new Loginisation();

    public static void main(String[] args) {
        Site site = new Site();

        int i = 0;
        while(i < 5) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What you want to dou?");
            System.out.println("For login enter 1, Register 2");
            int answer = scanner.nextInt();
            if(answer == 1) {
                site.loginisation.login();
            } else if(answer == 2){
                site.loginisation.registration();
            }
            i++;
        }
    }
}
