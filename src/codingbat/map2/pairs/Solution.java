package codingbat.map2.pairs;

import java.util.HashMap;
import java.util.Map;

/*

Учитывая массив непустых строк, создайте и верните Map<String, String> следующим образом: для каждой строки
добавьте ее первый символ в качестве ключа и последний символ в качестве значения.

pairs(["code", "bug"]) → {"b": "g", "c": "e"}
pairs(["man", "moon", "main"]) → {"m": "n"}
pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
 */
public class Solution {

    public Map<String, String> pairs(String[] strings) {

        Map<String, String> map = new HashMap<>();

        for (String string : strings) {

            String first = string.substring(0,1);
            String last = string.substring(string.length()-1);
            map.put(first, last);
        }
        return map;
    }

}
