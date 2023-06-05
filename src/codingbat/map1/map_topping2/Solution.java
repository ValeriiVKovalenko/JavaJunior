package codingbat.map1.map_topping2;

import java.util.Map;

/*

Учитывая карту ключей продуктов питания и их значений, измените и верните карту следующим образом: если ключ
"мороженое" имеет значение, установите его в качестве значения для ключа "йогурт". Если ключ "шпинат" имеет
значение, измените это значение на "орехи".

topping2({"ice cream": "cherry"}) → {"yogurt": "cherry", "ice cream": "cherry"}
topping2({"spinach": "dirt", "ice cream": "cherry"}) → {"yogurt": "cherry", "spinach": "nuts", "ice cream": "cherry"}
topping2({"yogurt": "salt"}) → {"yogurt": "salt"}
 */
public class Solution {

    public Map<String, String> topping2(Map<String, String> map) {

        if(map.containsKey("ice cream")) {
            map.put("yogurt", map.get("ice cream"));
        }

        if (map.containsKey("spinach")) {
            map.put("spinach", "nuts");
        }
        return map;
    }
}
