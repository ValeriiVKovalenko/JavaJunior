package regular_expressions;

import java.util.Arrays;

public class Regex3 {
    public static void main(String[] args) {
        String info
                = "John Smith, USA, New York, 123 Main Street, Apt 4B, john.smith@example.com, +11234567890;" +
                "Emily Johnson, Canada, Toronto, 456 Maple Avenue, Apt 7C, emily.johnson@example.com, +19876543210;" +
                "Alex Lee, UK, London, 789 Oak Street, Apt 2A, alex.lee@example.com, +44123456789;" +
                "Chloe Smith, United States, New York, Main Street, 10, 305, chloe.smith@example.com, +1555678911.";
        String s2 = "chloe.smith@example.com";
        boolean result = s2.matches("\\w+@\\w+\\.com");
        System.out.println(s2);

        String[] arr = info.split(",");
        System.out.println(Arrays.toString(arr));
    }

}
