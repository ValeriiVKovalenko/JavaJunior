package javarush.javarush_Tutorial;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        formula.calculate(100);
        formula.sqrt(16);

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String name1, String name2) {
//                return name1.compareTo(name2);
//            }
//        });

        Collections.sort(names, String::compareTo);

        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
//        System.out.println(converted);

        Something something = new Something();
        Converter<String, String> converter2 = something::startsWith;
        String converted2 = converter2.convert("Java");
        System.out.println(converted2);

        PersonFactory<Person> personFactory = Person::new;
        Person person1 = personFactory.create("John", "Wick");



    }
}
