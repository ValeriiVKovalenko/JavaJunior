package codingbat.map1.map_ab3;

import java.util.Map;

/*
Изменить и вернуть заданную карту следующим образом: если точно один из ключей "a" или "b" имеет значение в карте
(но не оба), установить, чтобы другой имел такое же значение в карте.

mapAB3({"a": "aaa", "c": "cake"}) → {"a": "aaa", "b": "aaa", "c": "cake"}
mapAB3({"b": "bbb", "c": "cake"}) → {"a": "bbb", "b": "bbb", "c": "cake"}
mapAB3({"a": "aaa", "b": "bbb", "c": "cake"}) → {"a": "aaa", "b": "bbb", "c": "cake"}
 */
public class Solution {

    public Map<String, String> mapAB3(Map<String, String> map) {

        if (map.containsKey("a") ^ map.containsKey("b")) {

            if(map.containsKey("a")) {
                map.put("b", map.get("a"));
            } else {
                map.put("a", map.get("b"));
            }
        }
        return map;
    }

}
