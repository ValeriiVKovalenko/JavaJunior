package javarush.site;

public class UserDataBase {

    private final User[] users;
    private int usersCount;

    public UserDataBase() {
        users = new User[100];
        users[0] = new User(1,"Login1", "Password1");
        users[1] = new User(2, "Login2", "Password2");
        users[2] = new User(3,"Login3", "Password3");
        users[3] = new User(4, "Login4", "Password4");
        users[4] = new User(5, "Login5", "Password5");
        usersCount = 5;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public User getUserByLoginAndPassword(String login, String password) {
        for (int i = 0; i < usersCount; i++) {
            if(users[i].getLogin().equals(login) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }
}
