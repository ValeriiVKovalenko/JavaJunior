package regular_expressions.task7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Напишите регулярное выражение, которое будет искать все слова, оканчивающиеся на "ing", в заданной строке.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.endIng("Terring");
    }

    public void endIng(String example) {
        Pattern pattern = Pattern.compile("\\b\\w*ing\\b");
        Matcher matcher = pattern.matcher(example);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
