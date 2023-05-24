package regular_expressions.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    /*
    Создайте регулярное выражение, которое будет проверять, является ли заданная строка действительным URL-адресом.
     */


    public boolean isUrlCorrect(String url) {
        Pattern pattern = Pattern.compile("https://[a-zA-Z0-9.-_]+\\.(com|org|net)");
        Matcher matcher = pattern.matcher(url);
        if(matcher.find()) {
            return true;
        } else  {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isUrlCorrect("https://facebook.com"));
    }
}
