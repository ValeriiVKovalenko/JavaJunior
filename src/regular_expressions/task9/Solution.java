package regular_expressions.task9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Напишите регулярное выражение, которое будет искать все HTML-теги в заданном HTML-коде.
 */
public class Solution {
    public void findHTMLTags(String example) {
        Pattern pattern = Pattern.compile("<[^>]+>");
        Matcher matcher = pattern.matcher(example);

        while (matcher.find()) {
            System.out.print(matcher.group());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findHTMLTags("<html>wweeeaaasssdw</html>");
        solution.findHTMLTags("<html><head><title>Example</title></head><body><h1>Hello, World!</h1></body></html>");
    }
}
