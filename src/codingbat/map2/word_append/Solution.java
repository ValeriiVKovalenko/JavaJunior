package codingbat.map2.word_append;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Перебирая заданный массив строк, постройте строку результата следующим образом: когда строка появляется в массиве
2-й, 4-й, 6-й и т.д. раз, добавьте ее к результату. Верните пустую строку, если ни одна строка не встречается во
второй раз.

wordAppend(["a", "b", "a"]) → "a"
wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
wordAppend(["a", "", "a"]) → "a"
 */
public class Solution {
    public String wordAppend(String[] strings) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        for (String string : strings) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
                if(map.get(string) %2 == 0) {
                    result.append(string);
                }
            } else {
                map.put(string, 1);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] arr = {"a", "b", "a", "c", "a", "d", "a"};
        System.out.println(solution.wordAppend(arr));
    }
}
