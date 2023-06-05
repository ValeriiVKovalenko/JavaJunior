package codingbat.map2.first_char;

import java.util.HashMap;
import java.util.Map;

/*
Учитывая массив непустых строк, верните Map<String, String> с ключом для каждого первого символа, значение всех строк,
начинающихся с этого символа, сложенных вместе в порядке их появления в массиве.

firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
firstChar([]) → {}
 */
public class Solution {

    public Map<String, String> firstChar(String[] strings) {

        Map<String, String> map = new HashMap<>();

        for (String string : strings) {
            String firstSymbol = string.substring(0, 1);
            map.merge(firstSymbol, string, String::concat);
        }
        return map;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] strings = {"salt", "tea", "soda", "toast"};
        System.out.println(solution.firstChar(strings));
    }
}
