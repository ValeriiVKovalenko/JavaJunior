package codingbat.map1.map_ab2;

import java.util.Map;

/*
Измените и верните заданную карту следующим образом: если ключи "a" и "b" находятся в карте и имеют одинаковые
значения, удалите их оба.

mapAB2({"a": "aaa", "b": "aaa", "c": "cake"}) → {"c": "cake"}
mapAB2({"a": "aaa", "b": "bbb"}) → {"a": "aaa", "b": "bbb"}
mapAB2({"a": "aaa", "b": "bbb", "c": "aaa"}) → {"a": "aaa", "b": "bbb", "c": "aaa"}
 */
public class Solution {

    public Map<String, String> mapAB2(Map<String, String> map) {

        if(map.containsKey("a") && map.containsKey("b")) {
            if (map.get("a").equals(map.get("b"))) {
                map.remove("a");
                map.remove("b");
            }
        }
        return map;
    }

}
