package javarush.site;

import java.util.Scanner;

public class Loginisation {

    private UserService userService = new UserService();
    private static final String ENTER_LOGIN = "Enter login: ";
    private static final String ENTER_PASS = "Enter password: ";

    public void login() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Loginisation");
        System.out.print(ENTER_LOGIN);
        String login = scanner.nextLine();

        System.out.print(ENTER_PASS);
        String password = scanner.nextLine();
        Authentication authentication = new Authentication(userService);
        if(authentication.authenticate(login, password)) {
            System.out.println("You logged in");
        } else {
            System.out.println("Incorrect login or password");
        }
    }

    public void registration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registration");
        System.out.print(ENTER_LOGIN);
        String login = scanner.nextLine();

        System.out.print(ENTER_PASS);
        String password = scanner.nextLine();

        userService.createUser(new User(login, password));

    }
}
