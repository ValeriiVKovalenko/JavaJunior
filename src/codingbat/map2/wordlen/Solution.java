package codingbat.map2.wordlen;

import java.util.HashMap;
import java.util.Map;

/*

Учитывая массив строк, возвращает Map<String, Integer>, содержащий ключ для каждой строки в массиве,
а значение - длину этой строки.

wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
 */
public class Solution {

    public Map<String, Integer> wordLen(String[] strings) {

        Map<String, Integer> map = new HashMap<>();

        for (String string : strings) {

            map.put(string, string.length());
        }
        return map;
    }

}
