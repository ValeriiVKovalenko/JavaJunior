package regular_expressions.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    /*
    Напишите регулярное выражение для проверки правильности формата email-адреса.
     */
    public static void main(String[] args) {
        String s1 = "valerii23ps4&gmail#com";

        System.out.println(isEmailCorrect(s1));
    }

    public static boolean isEmailCorrect(String email) {
        Pattern pattern = Pattern.compile("\\w+\\@\\w+\\.(com|net)");
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()) {
            return true;
        }
        else {
            return false;
        }
    }
}
