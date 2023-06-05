package codingbat.map2.word_count;

import java.util.HashMap;
import java.util.Map;

/*

Классический алгоритм подсчета слов: дается массив строк, возвращается Map<String, Integer> с ключом для каждой
отдельной строки, а значением является количество раз, которое эта строка встречается в массиве.

wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
wordCount(["c", "c", "c", "c"]) → {"c": 4}
 */
public class Solution {
    public Map<String, Integer> wordCount(String[] strings) {

        Map<String, Integer> map = new HashMap<>();

        for (String string : strings) {
            map.put(string, 0);
        }

        for (String string : strings) {

            map.computeIfPresent(string, (key, value) -> value + 1);
        }
        return map;
    }

}
