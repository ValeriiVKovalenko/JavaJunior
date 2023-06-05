package codingbat.map1.map_topping1;

import java.util.Map;

/*

Учитывая карту ключей продуктов питания и значений топпингов, измените и верните карту следующим образом:
если присутствует ключ "мороженое", установите его значение "вишня". Во всех случаях установите для ключа
"хлеб" значение "масло".

topping1({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
topping1({}) → {"bread": "butter"}
topping1({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}
 */
public class Solution {

    public Map<String, String> topping1(Map<String, String> map) {

        if (map.containsKey("ice cream")) {
            map.put("ice cream", "cherry");
        }

        map.put("bread", "butter");

        return map;
    }
}
