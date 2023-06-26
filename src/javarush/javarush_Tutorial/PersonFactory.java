package javarush.javarush_Tutorial;

public interface PersonFactory <P extends Person> {
    P create(String firstname, String lastname);
}
