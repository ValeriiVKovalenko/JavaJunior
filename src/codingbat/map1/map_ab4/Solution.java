package codingbat.map1.map_ab4;

import java.util.HashMap;
import java.util.Map;

/*

Измените и верните заданную карту следующим образом: если ключи "a" и "b" имеют значения разной длины, то установите
для "c" более длинное значение. Если значения существуют и имеют одинаковую длину, измените их оба на пустую строку
в карте.

mapAB4({"a": "aaa", "b": "bb", "c": "cake"}) → {"a": "aaa", "b": "bb", "c": "aaa"}
mapAB4({"a": "aa", "b": "bbb", "c": "cake"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
mapAB4({"a": "aa", "b": "bbb"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
 */
public class Solution {

    public Map<String, String> mapAB4(Map<String, String> map) {

        if (map.containsKey("a") && map.containsKey("b")) {

            if (map.get("a").length() > map.get("b").length()) {
                map.put("c", map.get("a"));
            } else if (map.get("a").length() < map.get("b").length()) {
                map.put("c", map.get("b"));
            } else {
                map.put("a", "");
                map.put("b", "");
            }
        }
        return map;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        Map<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bb");
        map.put("c", "cake");

        solution.mapAB4(map);
        System.out.println(map);

    }
}
