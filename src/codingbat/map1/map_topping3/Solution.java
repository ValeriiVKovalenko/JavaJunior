package codingbat.map1.map_topping3;

import java.util.Map;

/*
Учитывая карту ключей блюд и значений начинок, измените и верните карту следующим образом: если ключ "картофель"
имеет значение, установите его в качестве значения для ключа "картофель фри". Если ключ "салат" имеет значение,
установите его в качестве значения для ключа "шпинат".

topping3({"potato": "ketchup"}) → {"potato": "ketchup", "fries": "ketchup"}
topping3({"potato": "butter"}) → {"potato": "butter", "fries": "butter"}
topping3({"salad": "oil", "potato": "ketchup"}) → {"spinach": "oil", "salad": "oil", "potato": "ketchup", "fries": "ketchup"}
 */
public class Solution {

    public Map<String, String> topping3(Map<String, String> map) {

        if (map.containsKey("potato")) {
            map.put("fries", map.get("potato"));
        }
        if (map.containsKey("salad")) {
            map.put("spinach", map.get("salad"));
        }
        return map;
    }
}
