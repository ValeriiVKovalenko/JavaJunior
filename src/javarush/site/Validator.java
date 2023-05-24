package javarush.site;

public class Validator {
//    private User user;

    public boolean isValid(User user) {
        if(user.getLogin().isBlank() && user.getPassword().isBlank()) {
            return false;
        } else {
            return true;
        }
    }

}
