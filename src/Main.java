import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s1 = "abXYabc";
        System.out.println(prefixAgain(s1, 3));




    }
    public static boolean prefixAgain(String str, int n) {
        int j = 0;
        for (int i = 1; i < str.length() - n; i++) {

            if(str.substring(i, n).equals(str.substring(j, n))) {
                return true;
            }
        }
        return false;
    }





}