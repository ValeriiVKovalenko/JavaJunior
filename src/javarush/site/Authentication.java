package javarush.site;

public class Authentication {

    private UserService userService;

    public Authentication(UserService userService) {
        this.userService = userService;
    }

    public boolean authenticate(String login, String password) {
        User user = userService.getUserByLoginAndPassword(login, password);

        if(user != null)  {
            return true;
        } else {
            return false;
        }
    }
}
