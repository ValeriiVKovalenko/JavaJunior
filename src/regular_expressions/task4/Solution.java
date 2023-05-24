package regular_expressions.task4;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public void wordWithFirstVocableUpperCase(String text) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    /*
    Создайте регулярное выражение для поиска всех слов, начинающихся с заглавной буквы, в заданном тексте.
     */
    public static void main(String[] args) {
      String text = "Vivamus hendrerit orci in augue commodo faucibus. Nullam convallis nisl sed ipsum viverra," +
              " ut eleifend metus eleifend. Vestibulum lobortis interdum ipsum, vitae luctus neque accumsan eu." +
              " Aliquam id tellus nec ex facilisis cursus. In auctor mauris eu ex ultrices, ac pulvinar lorem faucibus." +
              " Sed luctus pellentesque massa, ac tristique velit dictum id. Vestibulum facilisis auctor tempor." +
              " Etiam venenatis purus et leo fringilla, in consequat lorem sollicitudin. Cras vulputate venenatis " +
              "dapibus. Integer vel ligula sit amet diam rutrum vestibulum. Integer ac sem nec sapien semper " +
              "efficitur at a turpis. Aliquam pellentesque ullamcorper semper. In non tellus eu sem congue " +
              "vestibulum. Aenean auctor ultricies sem, at gravida sapien ullamcorper at. Integer commodo, lectus " +
              "in pulvinar fermentum, nisi neque porta lectus, ut posuere nulla turpis vitae nisi.";
      Solution solution = new Solution();
        solution.wordWithFirstVocableUpperCase(text);
    }


}
