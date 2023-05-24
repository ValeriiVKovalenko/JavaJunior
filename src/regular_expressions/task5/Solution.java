package regular_expressions.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Напишите регулярное выражение, которое будет проверять, состоит ли заданная строка только из цифр.
 */
public class Solution {
    public boolean isStringOnlyWithNumbers(String example) {

        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(example);

        if(matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isStringOnlyWithNumbers("922"));
    }
}
