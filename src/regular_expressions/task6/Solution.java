package regular_expressions.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Создайте регулярное выражение для поиска всех дат в формате "dd/mm/yyyy" в заданном тексте.
 */
public class Solution {
    public void showAllData(String data) {
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.showAllData("23/01/1444");

    }
}
