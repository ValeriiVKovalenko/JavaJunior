package codingbat.map1.map_ab;

/*

Измените и верните заданную карту следующим образом: для данной задачи карта может содержать или не содержать ключи
"a" и "b". Если оба ключа присутствуют, сложите их 2 строковых значения вместе и сохраните результат под ключом "ab".

mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
mapAB({"a": "Hi"}) → {"a": "Hi"}
mapAB({"b": "There"}) → {"b": "There"}
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Map<String, String> mapAB(Map<String, String> map) {

        if(map.containsKey("a") && map.containsKey("b")) {
            map.put("ab", map.get("a") + map.get("b"));
        }
        return map;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "Hi");
        map1.put("b", "There");

        solution.mapAB(map1);

        System.out.println(map1);



    }

}
