package collections.set.test2;

import java.util.HashSet;
import java.util.Set;

public class ValueX {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("D");

        Set<String> set2 = new HashSet<>();
        set2.add("A");
        set2.add("E");
        set2.add("C");
        set2.add("F");

//        Set<String> result1 = new HashSet<>(set1);
//        result1.addAll(set2);
//        System.out.println(result1);
//        System.out.println("========");

//        Set<String> result2 = new HashSet<>(set2);
//        result2.retainAll(set1);
//        System.out.println(result2);
//        System.out.println("========");

        Set<String> result3 = new HashSet<>(set2);
        result3.removeAll(set1);
        System.out.println(result3);
        System.out.println("========");
    }
}
