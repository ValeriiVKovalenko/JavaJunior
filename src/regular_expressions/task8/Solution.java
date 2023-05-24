package regular_expressions.task8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Создайте регулярное выражение для проверки правильности формата телефонного номера в заданном формате.
 */

public class Solution {
    public void findCorrectPhoneNumber(String phoneNumbers) {
        Pattern pattern = Pattern.compile("\\+380\\d{10}+");
        Matcher matcher = pattern.matcher(phoneNumbers);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findCorrectPhoneNumber("+3801234567899");
    }
}
