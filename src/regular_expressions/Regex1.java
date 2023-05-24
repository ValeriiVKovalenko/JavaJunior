package regular_expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
    public static void main(String[] args) {
        String info
                = "John Smith, USA, New York, 123 Main Street, Apt 4B, john.smith@example.com, +11234567890;" +
                "Emily Johnson, Canada, Toronto, 456 Maple Avenue, Apt 7C, emily.johnson@example.com, +19876543210;" +
                "Alex Lee, UK, London, 789 Oak Street, Apt 2A, alex.lee@example.com, +44123456789;" +
                "Chloe Smith, United States, New York, Main Street, 10, 305, chloe.smith@example.com, +1555678911.";

//        Pattern pattern = Pattern.compile("\\w+");
//        Pattern pattern = Pattern.compile("\\b\\d{3}\\b");
//        Pattern pattern = Pattern.compile("\\+\\d{2}");
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.com");


        Matcher matcher = pattern.matcher(info);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
