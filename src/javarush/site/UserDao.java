package javarush.site;

public class UserDao {

    private UserDataBase userDataBase = new UserDataBase();

    public void save(User user) {
        User[] users = userDataBase.getUsers();
        int userCount = userDataBase.getUsersCount();
        users[userCount] = user;
        userDataBase.setUsersCount(++userCount);
    }

    public User getUserByLoginAndPassword(String login, String password) {
        return userDataBase.getUserByLoginAndPassword(login, password);
    }

}
