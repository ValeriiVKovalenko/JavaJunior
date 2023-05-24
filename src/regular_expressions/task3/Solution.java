package regular_expressions.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Напишите регулярное выражение, которое будет искать все числа в заданной строке.
 */
public class Solution {

    public void numbers(String number) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(number);

       while (matcher.find()) {
           System.out.println(matcher.group());
       }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numbers("345@33.qq1");

    }
}
