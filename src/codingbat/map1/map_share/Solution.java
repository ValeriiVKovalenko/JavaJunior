package codingbat.map1.map_share;

import java.util.HashMap;
import java.util.Map;

/*
Измените и верните данную карту следующим образом: если ключ "a" имеет значение, установите для ключа "b" такое же
значение. Во всех случаях удалите ключ "c", оставив остальную часть карты без изменений.

mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
 */
public class Solution {

    public Map<String, String> mapShare(Map<String, String> map) {

        if(map.containsKey("a")) {
            map.put("b", map.get("a"));
        }
        map.remove("c");
        return map;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "aaa");
        map1.put("b", "bbb");
        map1.put("c", "ccc");
        solution.mapShare(map1);

        Map<String, String> map2 = Map.of("b", "xyq", "c", "ccc");
        solution.mapShare(map2);

        System.out.println(map1);
        System.out.println(map2);
    }

}
