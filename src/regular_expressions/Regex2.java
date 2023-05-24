package regular_expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
//        String s1 = "ABCD ABCE ABCFABCGABCH";
//        Pattern pattern1 = Pattern.compile("ABC");

//        String s1 = "ABDEOP";
//        Pattern pattern1 = Pattern.compile("AB[C-F]OP");

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc[^e-g4-7]");

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc(e|5)");

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc$");

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w"); // [A-Za-z0-9_]

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w+");

//        String s1 = "poka valerii maks son djon karabanga";
//        Pattern pattern1 = Pattern.compile("\\w{4}");

//        String s1 = "poka     valerii      maks  son   djon karabanga";
//        Pattern pattern1 = Pattern.compile("\\w+\\S+");

//        String s1 = "abcd abce3 abcfa78abcg6cbch";
//        Pattern pattern1 = Pattern.compile("\\D{2,6}");

//        String s1 = "aabcababda";
//        Pattern pattern1 = Pattern.compile("(ab){2,3}");

//        String s1 = "dabcdababdababababd";
//        Pattern pattern1 = Pattern.compile("d(ab){2,}");

//        String s1 = "dabcdababdababababd";
//        Pattern pattern1 = Pattern.compile("d(ab)*");

        String s1 = "abcd abcd4 afc4ced7";
        Pattern pattern1 = Pattern.compile("[abcd][efg3-8]");

        Matcher matcher = pattern1.matcher(s1);
        while (matcher.find()) {
            System.out.println("position: " + matcher.start() + " " + matcher.group());
        }
    }
}
