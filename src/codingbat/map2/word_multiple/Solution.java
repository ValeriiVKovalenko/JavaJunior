package codingbat.map2.word_multiple;

import java.util.HashMap;
import java.util.Map;

/*
Учитывая массив строк, верните Map<String, Boolean>, где каждая отдельная строка является ключом, а ее значение
равно true, если эта строка встречается 2 или более раз в массиве.

wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
wordMultiple(["c", "c", "c", "c"]) → {"c": true}
 */
public class Solution {

    public Map<String, Boolean> wordMultiple(String[] strings) {

        Map<String, Boolean> map = new HashMap<>();

        for (String string : strings) {

            if (map.containsKey(string)) {
                map.put(string, true);
            } else {
                map.put(string, false);
            }
        }
        return map;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] arr = {"c", "b", "a"};
        System.out.println(solution.wordMultiple(arr));
    }
}
