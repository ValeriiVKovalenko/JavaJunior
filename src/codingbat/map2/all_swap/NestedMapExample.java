package codingbat.map2.all_swap;

import java.util.HashMap;
import java.util.Map;

public class NestedMapExample {
    public static void main(String[] args) {

        Map<String, Map<String, Integer>> nestedMap =new HashMap<>();

        String outerKey1 = "key1";
        String innerKey1 = "innerKey1";
        int value1 = 10;

        nestedMap.computeIfAbsent(outerKey1, k -> new HashMap<>()).put(innerKey1, value1);

        int retrievedValue = nestedMap.get(outerKey1).get(innerKey1);
        System.out.println("Retrieved value: " + retrievedValue);

        int updateValue = 20;
        nestedMap.get(outerKey1).put(innerKey1, updateValue);
        System.out.println("Update value: " + nestedMap.get(outerKey1).get(innerKey1));
    }
}
