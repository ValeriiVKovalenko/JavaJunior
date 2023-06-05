package codingbat.map2.word0;

import java.util.HashMap;
import java.util.Map;

/*

Учитывая массив строк, верните Map<String, Integer>, содержащий ключ для каждой строки в массиве, всегда со значением
0. Например, строка "hello" образует пару "hello":0. Позже мы сделаем более сложный подсчет, но для этой задачи
значение просто 0.

word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
 */
public class Solution {

    public Map<String, Integer> word0(String[] strings) {

        Map<String, Integer> result = new HashMap<>();

        for (String string : strings) {
            result.put(string, 0);
        }
        return result;
    }
}
