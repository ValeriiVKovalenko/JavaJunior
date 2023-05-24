package javarush.site;

public class UserService {

    private UserDao userDao = new UserDao();
    private Validator validator = new Validator();

    public void createUser(User user) {
        if(!validator.isValid(user)) {
            System.out.println("User is invalid");
            return;
        }

        userDao.save(user);
        System.out.println("User with login: " + user.getLogin() + " has been saved in Database.");
    }

    public User getUserByLoginAndPassword(String login, String password) {
        User user = userDao.getUserByLoginAndPassword(login, password);
        return user;
    }
}
